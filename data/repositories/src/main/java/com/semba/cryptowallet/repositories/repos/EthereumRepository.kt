package com.semba.cryptowallet.repositories.repos

interface EthereumRepository {
    suspend fun broadcastTransaction(rawData: String)
}