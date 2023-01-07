package com.semba.cryptowallet.domain

import com.semba.cryptowallet.model.wallet.WalletCurrency
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import wallet.core.jni.HDWallet
import javax.inject.Inject

class BroadcastTransactionUseCase @Inject constructor(val broadcastBitcoin: BitcoinBroadcastTransactionUseCase,
val broadcastEthereum: EthereumBroadcastTransactionUseCase,
val broadcastBinance: BinanceBroadcastTransactionUseCase,
val broadcastTron: TronBroadcastTransactionUseCase) {

    operator fun invoke(amount: Long, toAddress: String, walletCurrency: WalletCurrency) =
        when(walletCurrency) {
            WalletCurrency.BITCOIN -> broadcastBitcoin(amount, toAddress)
            WalletCurrency.ETHEREUM -> broadcastEthereum(amount, toAddress)
            WalletCurrency.BINANCE -> broadcastBinance(amount, toAddress)
            WalletCurrency.TRON -> broadcastTron(amount, toAddress)
        }
}