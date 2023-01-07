package com.semba.cryptowallet.model

import kotlinx.serialization.SerialName

data class TronBlockRawData (
    @SerialName("number") val number: Long? = null,
    @SerialName("txTrieRoot") val txTrieRoot: String? = null,
    @SerialName("witness_address") val witnessAddress: String? = null,
    @SerialName("parentHash") val parentHash: String? = null,
    @SerialName("version") val version: Int? = null,
    @SerialName("timestamp") val timestamp: Long? = null,
        )