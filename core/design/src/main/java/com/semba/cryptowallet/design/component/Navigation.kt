package com.semba.cryptowallet.design.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CwNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
)
{
    NavigationBar(
        modifier = modifier,
        contentColor = CwNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content)
}

@Composable
fun RowScope.CwNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
)
{
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = CwNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = CwNavigationDefaults.navigationContentColor(),
            selectedTextColor = CwNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = CwNavigationDefaults.navigationContentColor(),
            indicatorColor = CwNavigationDefaults.navigationIndicatorColor()
        ))
}



object CwNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant
    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer
    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
