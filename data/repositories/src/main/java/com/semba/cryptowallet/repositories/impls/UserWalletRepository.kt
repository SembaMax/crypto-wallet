package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.database.dao.UserWalletDao
import com.semba.cryptowallet.database.entities.UserWalletEntity
import com.semba.cryptowallet.network.WalletNetworkService
import com.semba.cryptowallet.repositories.repos.WalletRepository
import javax.inject.Inject

class UserWalletRepository @Inject constructor(val userWalletDao: UserWalletDao, val walletNetworkService: WalletNetworkService) : WalletRepository {

    override suspend fun saveWallet(privateKey: String, mnemonic: String) {
        userWalletDao.insertOrIgnoreUserWallet(UserWalletEntity(privateKey, mnemonic))
    }

    override suspend fun deleteWallet(privateKey: String) {
        userWalletDao.deleteUserWallets(listOf(privateKey))
    }

    override suspend fun broadcastTransaction(blockchain: String, rawData: String) {
        walletNetworkService.broadcastTransaction(blockchain = blockchain, rawData = rawData)
    }
}