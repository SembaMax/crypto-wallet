package com.semba.cryptowallet.domain

import com.semba.cryptowallet.model.wallet.WalletCurrency
import com.semba.cryptowallet.repositories.impls.UserWalletRepository
import kotlinx.coroutines.flow.flow
import wallet.core.jni.HDWallet
import javax.inject.Inject

class CreateNewWalletUseCase @Inject constructor(val userWalletRepository: UserWalletRepository) {

    operator fun invoke() = flow<Boolean> {
        val wallet = HDWallet(128, "")
        val mnemonic = wallet.mnemonic()

        userWalletRepository.saveWallet(mnemonic)
        emit(mnemonic != null)
    }
}