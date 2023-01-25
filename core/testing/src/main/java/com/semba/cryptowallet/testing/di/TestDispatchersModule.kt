package com.semba.cryptowallet.testing.di

import com.semba.cryptowallet.common.di.DispatchersModule
import com.semba.cryptowallet.common.dispatchers.AppDispatcher
import com.semba.cryptowallet.common.dispatchers.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DispatchersModule::class]
)
object TestDispatchersModule {

    @Provides
    @Dispatcher(AppDispatcher.IO)
    fun providesIODispatcher(testDispatcher: TestDispatcher): CoroutineDispatcher = testDispatcher
}