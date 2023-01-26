package com.semba.cryptowallet.model.wallet

data class EthereumTransactionResponse (
    val isSuccessful: Boolean? = null,
    val error: EthereumTransactionError? = null,
        )

data class EthereumTransactionError(
    val message: String? = null,
)