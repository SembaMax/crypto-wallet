package com.semba.cryptowallet.database.di

import android.content.Context
import androidx.room.Room
import com.semba.cryptowallet.database.CryptoWalletDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesCryptoWalletDatabase(@ApplicationContext context: Context) : CryptoWalletDatabase
    {
        return Room.databaseBuilder(context, CryptoWalletDatabase::class.java, "cyptowallet-database").build()
    }
}