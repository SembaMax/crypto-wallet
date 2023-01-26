package com.semba.cryptowallet.repositories.repos

import com.semba.cryptowallet.model.EthereumSendResponse
import com.semba.cryptowallet.model.wallet.EthereumTransactionResponse

interface EthereumRepository {
    suspend fun sendTransaction(rawTransaction: String): EthereumTransactionResponse
}