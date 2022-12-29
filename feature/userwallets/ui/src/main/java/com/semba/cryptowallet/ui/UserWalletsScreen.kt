package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun UserWalletsScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: UserWalletsViewModel = hiltViewModel()
) {
    val userWalletsState by viewModel.userWalletsUiState.collectAsStateWithLifecycle()
    UserWalletsScreen(userWalletsState, modifier)
}

@Composable
fun UserWalletsScreen(
    userWalletsState: UserWalletsScreenUiState,
    modifier: Modifier = Modifier
) {

}