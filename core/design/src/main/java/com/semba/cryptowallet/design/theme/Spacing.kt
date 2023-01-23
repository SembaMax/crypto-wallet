package com.semba.cryptowallet.design.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val globalHorizontal: Dp = 10.dp,
    val globalVertical: Dp = 15.dp,
)

//Creates spacing composition local
val LocalSpacing = compositionLocalOf { Spacing() }

//Add spacing to Material Theme
val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current