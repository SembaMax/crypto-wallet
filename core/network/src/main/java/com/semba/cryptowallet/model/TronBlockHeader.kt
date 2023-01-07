package com.semba.cryptowallet.model

import kotlinx.serialization.SerialName

data class TronBlockHeader (
    @SerialName("raw_data") var rawData: TronBlockRawData? = null,
    @SerialName("witness_signature") var witnessSignature: String? = null,
        )