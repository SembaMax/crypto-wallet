package com.semba.cryptowallet.model

import kotlinx.serialization.SerialName

data class LatestBlockBean (
    @SerialName("blockID") val blockID: String? = null,
    @SerialName("block_header") val blockHeader: TronBlockHeader? = null
        )