package com.semba.cryptowallet.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semba.cryptowallet.database.dao.UserWalletDao
import com.semba.cryptowallet.database.entities.UserWalletEntity

@Database(
    entities = [UserWalletEntity::class], version = 2, exportSchema = false
)
abstract class CryptoWalletDatabase: RoomDatabase() {
    abstract fun userWalletsDao(): UserWalletDao
}