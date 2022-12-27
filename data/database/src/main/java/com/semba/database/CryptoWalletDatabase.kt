package com.semba.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semba.database.dao.UserWalletDao
import com.semba.database.entities.UserWalletEntity

@Database(
    entities = [UserWalletEntity::class], version = 1, exportSchema = false
)
abstract class CryptoWalletDatabase: RoomDatabase() {
    abstract fun userWalletsDao(): UserWalletDao
}