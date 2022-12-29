package com.semba.cryptowallet.database.di

import com.semba.cryptowallet.database.CryptoWalletDatabase
import com.semba.cryptowallet.database.dao.UserWalletDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaosModule {

    @Provides
    fun providesUserWalletDao(database: CryptoWalletDatabase): UserWalletDao
    {
        return database.userWalletsDao()
    }
}