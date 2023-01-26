package com.semba.cryptowallet.repositories.repos

import com.semba.cryptowallet.model.wallet.TronBlockHeader
import com.semba.cryptowallet.model.wallet.TronTransactionResponse

interface TronRepository {
    suspend fun broadcastTransaction(rawData: String): TronTransactionResponse
    suspend fun getLatestBlock(): TronBlockHeader
}