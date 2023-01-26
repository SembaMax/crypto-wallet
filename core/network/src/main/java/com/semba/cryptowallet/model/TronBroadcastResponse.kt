package com.semba.cryptowallet.model

import com.semba.cryptowallet.model.wallet.TronTransactionResponse

data class TronBroadcastResponse(
    val result: Boolean? = null
)


fun TronBroadcastResponse.toModel() = TronTransactionResponse(
    isSuccessful = this.result
)