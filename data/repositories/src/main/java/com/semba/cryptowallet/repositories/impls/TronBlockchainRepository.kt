package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.model.LatestBlockBean
import com.semba.cryptowallet.model.TronBroadcastResponse
import com.semba.cryptowallet.network.TronNetworkService
import com.semba.cryptowallet.repositories.repos.TronRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

class TronBlockchainRepository @Inject constructor(val tronNetworkService: TronNetworkService) : TronRepository {

    override suspend fun broadcastTransaction(rawData: String): TronBroadcastResponse {
        return tronNetworkService.broadcastTransaction(rawData = rawData.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())).data
    }

    override suspend fun getLatestBlock(): LatestBlockBean {
        val blockNumObject = JSONObject()
        blockNumObject.put("num", 1)
        return tronNetworkService.getLatestBlock(blockNum = blockNumObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())).data
    }
}