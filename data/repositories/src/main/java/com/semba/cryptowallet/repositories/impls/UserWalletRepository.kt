package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.database.dao.UserWalletDao
import com.semba.cryptowallet.database.entities.UserWalletEntity
import com.semba.cryptowallet.network.WalletNetworkService
import com.semba.cryptowallet.repositories.repos.WalletRepository
import kotlinx.coroutines.coroutineScope
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class UserWalletRepository @Inject constructor(val userWalletDao: UserWalletDao, val walletNetworkService: WalletNetworkService) : WalletRepository {

    override suspend fun saveWallet(mnemonic: String) {
        userWalletDao.insertOrIgnoreUserWallet(UserWalletEntity(mnemonic))
    }

    override suspend fun deleteWallet(privateKey: String) {
        userWalletDao.deleteUserWallets(listOf(privateKey))
    }
}