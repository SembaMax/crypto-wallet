package com.semba.cryptowallet.repositories.repos

import com.semba.cryptowallet.model.LatestBlockBean
import com.semba.cryptowallet.model.TronBroadcastResponse

interface TronRepository {
    suspend fun broadcastTransaction(rawData: String): TronBroadcastResponse
    suspend fun getLatestBlock(): LatestBlockBean
}