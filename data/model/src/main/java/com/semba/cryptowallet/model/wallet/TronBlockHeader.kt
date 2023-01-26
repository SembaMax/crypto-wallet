package com.semba.cryptowallet.model.wallet

import kotlinx.serialization.SerialName

data class TronBlockHeader (
    val number: Long? = null,
    val version: Int? = null,
    val timestamp: Long? = null,
    val txTrieRoot: String? = null,
    val witnessAddress: String? = null,
    val parentHash: String? = null,
        )