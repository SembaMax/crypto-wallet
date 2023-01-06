package com.semba.cryptowallet.domain

import com.semba.cryptowallet.repositories.impls.UserWalletRepository
import kotlinx.coroutines.flow.flow
import wallet.core.jni.HDWallet
import javax.inject.Inject

class ImportWalletUseCase @Inject constructor(val userWalletRepository: UserWalletRepository) {

    operator fun invoke(mnemonic: String) = flow<Boolean> {
        val wallet = HDWallet(mnemonic, "")
        userWalletRepository.saveWallet(mnemonic)
        emit(wallet.mnemonic() != null)
    }
}