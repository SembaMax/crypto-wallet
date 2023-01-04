package com.semba.cryptowallet.repositories.repos

interface WalletRepository {

    suspend fun saveWallet(privateKey: String, mnemonic: String)
    suspend fun deleteWallet(privateKey: String)
    suspend fun broadcastTransaction(blockchain: String, rawData: String)
}