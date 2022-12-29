package com.semba.cryptowallet.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (
    tableName = "user_wallets"
        )
data class UserWalletEntity (
    @PrimaryKey
    val address: String,
    val coinType: String
    )