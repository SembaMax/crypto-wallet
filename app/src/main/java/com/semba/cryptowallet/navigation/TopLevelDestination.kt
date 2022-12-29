package com.semba.cryptowallet.navigation

import com.semba.cryptowallet.design.icon.Icon
import com.semba.cryptowallet.design.icon.Icon.DrawableResourceIcon
import com.semba.cryptowallet.design.icon.Icons
import com.semba.cryptowallet.feature.homescreen.ui.R as HomeR
import com.semba.cryptowallet.feature.userwallets.ui.R as UserWalletsR
import com.semba.cryptowallet.feature.wallethistory.ui.R as WalletHistoryR

enum class TopLevelDestination (
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val textId: Int,
        )
{
    HOME(
        selectedIcon = DrawableResourceIcon(Icons.MenuHomeOn),
        unselectedIcon = DrawableResourceIcon(Icons.MenuHomeOff),
        textId = HomeR.string.home_menu_text
    ),
    USER_WALLETS(
        selectedIcon = DrawableResourceIcon(Icons.MenuWalletOn),
        unselectedIcon = DrawableResourceIcon(Icons.MenuWalletOff),
        textId = UserWalletsR.string.user_wallets_menu_text
    ),
    WALLET_HISTORY(
        selectedIcon = DrawableResourceIcon(Icons.MenuHistoryOn),
        unselectedIcon = DrawableResourceIcon(Icons.MenuHistoryOff),
        textId = WalletHistoryR.string.history_menu_text
    )
}