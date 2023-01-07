package com.semba.cryptowallet.repositories.repos

interface BitcoinRepository {
    suspend fun broadcastTransaction(rawData: String)
}