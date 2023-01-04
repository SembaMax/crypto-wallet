package com.semba.cryptowallet.domain

import com.semba.cryptowallet.model.wallet.WalletCurrency
import wallet.core.jni.HDWallet
import javax.inject.Inject

class CreateNewWalletUseCase @Inject constructor() {

    operator fun invoke() {
        val wallet = HDWallet(128, "")

    }
}