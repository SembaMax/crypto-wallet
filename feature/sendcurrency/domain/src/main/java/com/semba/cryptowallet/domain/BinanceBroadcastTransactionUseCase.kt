package com.semba.cryptowallet.domain

import com.semba.cryptowallet.repositories.impls.BinanceBlockchainRepository
import com.semba.cryptowallet.repositories.impls.OfflineUserDataRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import javax.inject.Inject

class BinanceBroadcastTransactionUseCase @Inject constructor(val binanceRepository: BinanceBlockchainRepository,
                                                             val userDataRepository: OfflineUserDataRepository
) {

    operator fun invoke(amount: Long, toAddress: String) =
        flow<Boolean> {

            userDataRepository.userData.collectLatest { userData ->
                val wallet = HDWallet(userData.currentWalletMnemonic, "")
                val address = wallet.getAddressForCoin(CoinType.BINANCE)

            }
        }
}