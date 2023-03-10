package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.model.toModel
import com.semba.cryptowallet.model.wallet.TronBlockHeader
import com.semba.cryptowallet.model.wallet.TronTransactionResponse
import com.semba.cryptowallet.network.TronNetworkService
import com.semba.cryptowallet.repositories.repos.TronRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

class TronBlockchainRepository @Inject constructor(val tronNetworkService: TronNetworkService) : TronRepository {

    override suspend fun broadcastTransaction(rawData: String): TronTransactionResponse {
        val result = tronNetworkService.broadcastTransaction(rawData = rawData.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())).data
        return result.toModel()
    }

    override suspend fun getLatestBlock(): TronBlockHeader {
        val blockNumObject = JSONObject()
        blockNumObject.put("num", 1)
        val result = tronNetworkService.getLatestBlock(blockNum = blockNumObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())).data
        return result.toModel()
    }
}