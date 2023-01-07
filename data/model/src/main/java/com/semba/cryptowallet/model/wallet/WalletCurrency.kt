package com.semba.cryptowallet.model.wallet

import wallet.core.jni.CoinType

enum class WalletCurrency (val coinType : CoinType) {
    BITCOIN (CoinType.BITCOIN) ,
    ETHEREUM (CoinType.ETHEREUM) ,
    BINANCE (CoinType.BINANCE) ,
    TRON (CoinType.TRON)

}