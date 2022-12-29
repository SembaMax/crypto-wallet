package com.semba.cryptowallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import com.semba.cryptowallet.MainActivityUiState.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.semba.cryptowallet.common.network.NetworkMonitor
import com.semba.cryptowallet.model.common.ThemeConfig
import com.semba.cryptowallet.ui.CryptoWalletApp
import com.semba.cryptowallet.ui.theme.CryptoWalletTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: MainActivityUiState by mutableStateOf(Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.onEach {
                    uiState = it
                }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when(uiState)
            {
                Loading -> true
                is Success -> false
            }
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val isDarkTheme = shouldUseDarkTheme(uiState)

            DisposableEffect(systemUiController, isDarkTheme) {
                systemUiController.systemBarsDarkContentEnabled = !isDarkTheme
                onDispose {  }
            }

            CryptoWalletTheme (darkTheme = isDarkTheme) {
                CryptoWalletApp(networkMonitor = networkMonitor)
            }
        }
    }
}

@Composable
private fun shouldUseDarkTheme(uiState: MainActivityUiState): Boolean
= when (uiState) {
    Loading -> false
    is Success -> when (uiState.userData.themeConfig) {
        ThemeConfig.DARK -> true
        ThemeConfig.LIGHT -> false
        ThemeConfig.SYSTEM -> isSystemInDarkTheme()
    }
}