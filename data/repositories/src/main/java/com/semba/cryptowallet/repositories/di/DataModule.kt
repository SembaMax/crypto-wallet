package com.semba.cryptowallet.repositories.di

import com.semba.cryptowallet.repositories.impls.OfflineUserDataRepository
import com.semba.cryptowallet.repositories.repos.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsUserDataRepository(userDataRepository: OfflineUserDataRepository): UserDataRepository

}