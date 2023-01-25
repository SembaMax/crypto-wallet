package com.semba.cryptowallet.testing.di

import com.semba.cryptowallet.common.di.ConnectivityModule
import com.semba.cryptowallet.common.network.NetworkMonitor
import com.semba.cryptowallet.testing.util.TestNetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ConnectivityModule::class]
)
interface TestConnectivityModule {
    
    @Binds
    fun bindsTestNetworkMonitor(testNetworkMonitor: TestNetworkMonitor): NetworkMonitor
}