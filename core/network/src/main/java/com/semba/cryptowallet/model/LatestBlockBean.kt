package com.semba.cryptowallet.model

import com.semba.cryptowallet.model.wallet.TronBlockHeader
import kotlinx.serialization.SerialName

data class LatestBlockBean (
    @SerialName("blockID") val blockID: String? = null,
    @SerialName("block_header") val blockHeader: BlockHeader? = null
        )


data class BlockHeader (
    @SerialName("raw_data") var rawData: TronBlockRawData? = null,
    @SerialName("witness_signature") var witnessSignature: String? = null,
)


data class TronBlockRawData (
    @SerialName("number") val number: Long? = null,
    @SerialName("txTrieRoot") val txTrieRoot: String? = null,
    @SerialName("witness_address") val witnessAddress: String? = null,
    @SerialName("parentHash") val parentHash: String? = null,
    @SerialName("version") val version: Int? = null,
    @SerialName("timestamp") val timestamp: Long? = null,
)


fun LatestBlockBean.toModel() = TronBlockHeader(
    number = this.blockHeader?.rawData?.number,
    version = this.blockHeader?.rawData?.version,
    txTrieRoot = this.blockHeader?.rawData?.txTrieRoot,
    witnessAddress = this.blockHeader?.rawData?.witnessAddress,
    parentHash = this.blockHeader?.rawData?.parentHash,
    timestamp = this.blockHeader?.rawData?.timestamp,
)