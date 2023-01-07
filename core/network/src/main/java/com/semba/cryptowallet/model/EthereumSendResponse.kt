package com.semba.cryptowallet.model

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