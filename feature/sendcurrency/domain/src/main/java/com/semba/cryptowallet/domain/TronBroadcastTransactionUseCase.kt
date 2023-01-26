package com.semba.cryptowallet.domain

import com.google.protobuf.ByteString
import com.semba.cryptowallet.common.utils.hexStringToByteArray
import com.semba.cryptowallet.repositories.impls.OfflineUserDataRepository
import com.semba.cryptowallet.repositories.repos.TronRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import wallet.core.java.AnySigner
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import wallet.core.jni.proto.Tron
import javax.inject.Inject

class TronBroadcastTransactionUseCase @Inject constructor(val tronRepository: TronRepository,
                                                          val userDataRepository: OfflineUserDataRepository) {

    operator fun invoke(amount: Long, toAddress: String) = flow<Boolean> {

        userDataRepository.userData.collectLatest { userData ->
            val wallet = HDWallet(userData.currentWalletMnemonic, "")
            val ownerAddress = wallet.getAddressForCoin(CoinType.TRON)
            val privatekey = wallet.getKeyForCoin(CoinType.TRON)

            val transferContract = Tron.TransferAssetContract.newBuilder().apply {
                setOwnerAddress(ownerAddress)
                setToAddress(toAddress)
                setAmount(amount * 10000)
                setAssetName("") //Set Asset Name
            }.build()

            val blockBean = tronRepository.getLatestBlock()

            val time: Long = blockBean.timestamp ?: 0L

            val blockHeader = Tron.BlockHeader.newBuilder()
                .setTimestamp(time)
                .setTxTrieRoot(
                    ByteString.copyFrom(
                        blockBean.txTrieRoot?.hexStringToByteArray()
                    )
                )
                .setParentHash(
                    ByteString.copyFrom(
                        blockBean.parentHash?.hexStringToByteArray()
                    )
                )
                .setWitnessAddress(
                    ByteString.copyFrom(
                        blockBean.witnessAddress?.hexStringToByteArray()
                    )
                )
                .setNumber(blockBean.number ?: 0L)
                .setVersion(blockBean.version ?: 0)
                .build()

            val transaction = Tron.Transaction.newBuilder().apply {
                setTimestamp(time)
                setTransferAsset(transferContract)
                setExpiration(time + (20 * 60 * 1000))
                setBlockHeader(blockHeader)
            }.build()

            val signingInput = Tron.SigningInput.newBuilder().apply {
                setTransaction(transaction)
                setPrivateKey(ByteString.copyFrom(privatekey.data()))
            }.build()

            var output: Tron.SigningOutput? = null
            try {
                output = AnySigner.sign(signingInput, CoinType.TRON, Tron.SigningOutput.parser())
            } catch (e: Exception) {
                e.printStackTrace()
            }

            tronRepository.broadcastTransaction(output?.json ?: "").isSuccessful
        }
    }

}