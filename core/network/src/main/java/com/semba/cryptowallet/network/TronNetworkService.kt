package com.semba.cryptowallet.network

import com.semba.cryptowallet.model.TronBroadcastResponse
import com.semba.cryptowallet.model.LatestBlockBean
import com.semba.cryptowallet.model.NetworkResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface TronNetworkService {

    @POST(Routes.TRON_BROADCAST_TRANSACTION)
    suspend fun broadcastTransaction(@Body rawData: RequestBody): NetworkResponse<TronBroadcastResponse>

    @POST(Routes.TRON_LATEST_BLOCK)
    suspend fun getLatestBlock(@Body blockNum: RequestBody): NetworkResponse<LatestBlockBean>

}