package com.semba.cryptowallet.design.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.semba.cryptowallet.core.design.R

object CwIcons {
    val MenuHomeOn = R.drawable.ic_home_menu_on
    val MenuHomeOff = R.drawable.ic_home_menu_off
    val MenuMarketOn = R.drawable.ic_market_menu_on
    val MenuMarketOff = R.drawable.ic_market_menu_off
    val MenuWalletOn = R.drawable.ic_wallet_menu_on
    val MenuWalletOff = R.drawable.ic_wallet_menu_off
    val Settings = R.drawable.ic_settings
    val Info = R.drawable.ic_info
    val AddWallet = R.drawable.ic_add_wallet
    val Send = R.drawable.ic_send
    val Receive = R.drawable.ic_receive
}

sealed class CwIcon {
    data class ImageVectorIcon(val imageVector: ImageVector) : CwIcon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : CwIcon()
}
