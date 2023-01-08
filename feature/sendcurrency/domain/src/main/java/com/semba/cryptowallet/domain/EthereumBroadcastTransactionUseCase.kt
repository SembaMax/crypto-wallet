package com.semba.cryptowallet.domain

import com.google.protobuf.ByteString
import com.semba.cryptowallet.repositories.impls.EthereumBlockchainRepository
import com.semba.cryptowallet.repositories.impls.OfflineUserDataRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import wallet.core.java.AnySigner
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import wallet.core.jni.proto.Ethereum
import java.math.BigInteger
import javax.inject.Inject

class EthereumBroadcastTransactionUseCase @Inject constructor(val ethereumRepository: EthereumBlockchainRepository,
                                                              val userDataRepository: OfflineUserDataRepository
) {

    operator fun invoke(amount: Long, toAddress: String) =
        flow<Boolean> {

            userDataRepository.userData.collectLatest { userData ->
                val wallet = HDWallet(userData.currentWalletMnemonic, "")
                val ownerAddress = wallet.getAddressForCoin(CoinType.ETHEREUM)
                val privatekey = wallet.getKeyForCoin(CoinType.TRON)

                val signerInput = Ethereum.SigningInput.newBuilder().apply {
                    this.chainId = ByteString.copyFrom(BigInteger("01").toByteArray())
                    this.gasPrice = ByteString.copyFrom(BigInteger("d693a400", 16).toByteArray())
                    this.gasLimit = ByteString.copyFrom(BigInteger("5208", 16).toByteArray())
                    this.toAddress = toAddress
                    this.transaction = Ethereum.Transaction.newBuilder().apply {
                        this.transfer = Ethereum.Transaction.Transfer.newBuilder().apply {
                            this.amount = ByteString.copyFrom(amount.toBigInteger().toByteArray())
                        }.build()
                    }.build()
                    this.privateKey = ByteString.copyFrom(privatekey.data())
                }.build()
                val signerOutput = AnySigner.sign(signerInput, CoinType.ETHEREUM, Ethereum.SigningOutput.parser())

                ethereumRepository.sendTransaction(signerOutput.toString())
            }
        }
}