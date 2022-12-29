package com.semba.cryptowallet.design.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.semba.cryptowallet.design.theme.LocalBackgroundTheme

@Composable
fun CwBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
)
{
    val color = LocalBackgroundTheme.current.color
    val contentElevation = LocalBackgroundTheme.current.elevation

    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        tonalElevation = if (contentElevation == Dp.Unspecified) 0.dp else contentElevation,
        modifier = modifier.fillMaxSize()) {
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}