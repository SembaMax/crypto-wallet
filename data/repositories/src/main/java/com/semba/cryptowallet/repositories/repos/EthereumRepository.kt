package com.semba.cryptowallet.repositories.repos

import com.semba.cryptowallet.model.EthereumSendResponse

interface EthereumRepository {
    suspend fun sendTransaction(rawTransaction: String): EthereumSendResponse
}