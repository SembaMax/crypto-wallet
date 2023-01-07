package com.semba.cryptowallet.repositories.repos

interface BinanceRepository {
    suspend fun broadcastTransaction(rawData: String)
}