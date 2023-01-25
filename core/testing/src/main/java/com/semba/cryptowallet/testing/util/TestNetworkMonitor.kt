package com.semba.cryptowallet.testing.util

import com.semba.cryptowallet.common.network.NetworkMonitor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TestNetworkMonitor: NetworkMonitor {

    private val connectivityFlow = MutableStateFlow(true)

    override val isOnline: Flow<Boolean> = connectivityFlow

    fun setConnected(isConnected: Boolean) {
        connectivityFlow.value = isConnected
    }
}