package com.semba.cryptowallet.repositories.repos

interface WalletRepository {

    suspend fun saveWallet(mnemonic: String)
    suspend fun deleteWallet(privateKey: String)
    suspend fun broadcastTransaction(blockchain: String, rawData: String)
}