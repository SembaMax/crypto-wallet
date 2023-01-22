package com.semba.cryptowallet.model.wallet

import com.semba.cryptowallet.core.design.R as DesignR
import wallet.core.jni.CoinType

enum class WalletCurrency (val coinType : CoinType, val iconRes: Int) {
    BITCOIN (CoinType.BITCOIN, DesignR.drawable.ic_bitcoin) ,
    ETHEREUM (CoinType.ETHEREUM, DesignR.drawable.ic_ethereum) ,
    BINANCE (CoinType.BINANCE, DesignR.drawable.ic_binance) ,
    TRON (CoinType.TRON, DesignR.drawable.ic_tron)

}