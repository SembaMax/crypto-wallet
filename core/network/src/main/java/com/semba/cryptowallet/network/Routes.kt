package com.semba.cryptowallet.network

object Routes {
    const val BASE_URL = "https://rest.cryptoapis.io/"
    const val BROADCAST_TRANSACTION = "blockchain-tools/{blockchain}/{network}/transactions/broadcast"
    const val LATEST_BLOCK = "blockchain-data/{blockchain}/{network}/blocks/last"
}