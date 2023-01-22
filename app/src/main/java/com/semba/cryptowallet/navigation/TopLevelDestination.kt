package com.semba.cryptowallet.navigation

import com.semba.cryptowallet.design.icon.CwIcon
import com.semba.cryptowallet.design.icon.CwIcon.DrawableResourceIcon
import com.semba.cryptowallet.design.icon.CwIcons
import com.semba.cryptowallet.feature.homescreen.ui.R as HomeR
import com.semba.cryptowallet.feature.userwallets.ui.R as UserWalletsR
import com.semba.cryptowallet.feature.market.ui.R as MarketR

enum class TopLevelDestination (
    val selectedIcon: CwIcon,
    val unselectedIcon: CwIcon,
    val textId: Int,
    val titleTextId: Int
        )
{
    HOME(
        selectedIcon = DrawableResourceIcon(CwIcons.MenuHomeOn),
        unselectedIcon = DrawableResourceIcon(CwIcons.MenuHomeOff),
        textId = HomeR.string.home_menu_text,
        titleTextId = HomeR.string.home_menu_text
    ),
    USER_WALLETS(
        selectedIcon = DrawableResourceIcon(CwIcons.MenuWalletOn),
        unselectedIcon = DrawableResourceIcon(CwIcons.MenuWalletOff),
        textId = UserWalletsR.string.user_wallets_menu_text,
        titleTextId = UserWalletsR.string.user_wallets_menu_text
    ),
    WALLET_HISTORY(
        selectedIcon = DrawableResourceIcon(CwIcons.MenuMarketOn),
        unselectedIcon = DrawableResourceIcon(CwIcons.MenuMarketOff),
        textId = MarketR.string.market_menu_text,
        titleTextId = MarketR.string.market_menu_text
    )
}