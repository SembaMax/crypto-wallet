package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.model.EthereumSendResponse
import com.semba.cryptowallet.network.EthereumNetworkService
import com.semba.cryptowallet.repositories.repos.EthereumRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class EthereumBlockchainRepository @Inject constructor(val ethereumNetworkService: EthereumNetworkService): EthereumRepository {

    override suspend fun sendTransaction(rawTransaction: String): EthereumSendResponse {
        return ethereumNetworkService.sendTransaction(rawTransaction = rawTransaction.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())).data
    }
}