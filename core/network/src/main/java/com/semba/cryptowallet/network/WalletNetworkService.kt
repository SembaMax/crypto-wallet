package com.semba.cryptowallet.network

import android.os.Build
import com.semba.cryptowallet.model.BroadcastResponse
import com.semba.cryptowallet.model.LatestBlockBean
import com.semba.cryptowallet.model.NetworkResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Retrofit API declaration
 */
interface WalletNetworkService {

    @POST(Routes.BROADCAST_TRANSACTION)
    suspend fun broadcastTransaction(@Path("blockchain") blockchain: String, @Path("network") network: String, @Body rawData: RequestBody): NetworkResponse<BroadcastResponse>

    @POST(Routes.LATEST_BLOCK)
    suspend fun getLatestBlock(@Path("blockchain") blockchain: String, @Path("network") network: String = BuildConfig.BLOCKCHAIN_NETWORK): NetworkResponse<LatestBlockBean>

}