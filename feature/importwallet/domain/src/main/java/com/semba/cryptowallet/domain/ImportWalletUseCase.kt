package com.semba.cryptowallet.domain

import com.semba.cryptowallet.repositories.impls.UserWalletRepository
import javax.inject.Inject

class ImportWalletUseCase @Inject constructor(val userWalletRepository: UserWalletRepository) {

    operator fun invoke(mnemonic: String)
    {

    }
}