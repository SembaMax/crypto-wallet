package com.semba.cryptowallet.model

import com.semba.cryptowallet.model.wallet.EthereumTransactionError
import com.semba.cryptowallet.model.wallet.EthereumTransactionResponse

data class EthereumSendResponse (
    val id: Int? = null,
    val jsonrpc: String? = null,
    val result: String? = null,
    val error: EthereumSendError? = null,
        )

data class EthereumSendError (
    val code: String? = null,
    val message: String? = null,
    val data: String? = null,
        )


fun EthereumSendResponse.toModel() = EthereumTransactionResponse (
    isSuccessful = !this.result.isNullOrEmpty() && this.error == null,
    error = this.error?.toModel()
        )

fun EthereumSendError.toModel() = EthereumTransactionError(
    message = this.message
)