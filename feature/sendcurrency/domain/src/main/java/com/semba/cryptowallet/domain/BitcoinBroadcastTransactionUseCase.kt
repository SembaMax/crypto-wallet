package com.semba.cryptowallet.domain

import com.semba.cryptowallet.model.wallet.WalletCurrency
import com.semba.cryptowallet.repositories.impls.OfflineUserDataRepository
import com.semba.cryptowallet.repositories.impls.UserWalletRepository
import com.semba.cryptowallet.repositories.repos.BitcoinRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import javax.inject.Inject

class BitcoinBroadcastTransactionUseCase @Inject constructor(val bitcoinRepository: BitcoinRepository,
                                                             val userDataRepository: OfflineUserDataRepository
) {

    operator fun invoke(amount: Long, toAddress: String) =
        flow<Boolean> {

            userDataRepository.userData.collectLatest { userData ->
                val wallet = HDWallet(userData.currentWalletMnemonic, "")
                val address = wallet.getAddressForCoin(CoinType.BITCOIN)


            }
        }
}