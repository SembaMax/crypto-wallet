package com.semba.cryptowallet.database.dao

import androidx.room.*
import com.semba.cryptowallet.database.entities.UserWalletEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserWalletDao {

    @Query("SELECT * FROM user_wallets")
    fun getUserWallets(): Flow<List<UserWalletEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUserWallet(entity: UserWalletEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUserWallets(entities: List<UserWalletEntity>): List<Long>

    @Update
    suspend fun updateUserWallets(entities: List<UserWalletEntity>)

    @Query(
        value = "DELETE FROM user_wallets WHERE mnemonic in (:mnemonics)"
    )
    suspend fun deleteUserWallets(mnemonics: List<String>)

    @Query("DELETE FROM user_wallets")
    suspend fun drop()

    @Delete
    suspend fun dropUserWallet(userWalletEntity: UserWalletEntity): Int
}