package com.semba.cryptowallet.network

import com.semba.cryptowallet.model.EthereumSendResponse
import com.semba.cryptowallet.model.NetworkResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface EthereumNetworkService {

    @POST
    suspend fun sendTransaction(@Body rawData: RequestBody): NetworkResponse<EthereumSendResponse>
}