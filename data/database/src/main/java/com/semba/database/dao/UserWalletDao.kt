package com.semba.database.dao

import androidx.room.*
import com.semba.database.entities.UserWalletEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserWalletDao {

    @Query("SELECT * FROM user_wallets")
    fun getUserWallets(): Flow<List<UserWalletEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUserWallet(entities: List<UserWalletEntity>): List<Long>

    @Update
    suspend fun updateUserWallets(entities: List<UserWalletEntity>)

    @Query(
        value = "DELETE FROM user_wallets WHERE address in (:addresses)"
    )
    suspend fun deleteUserWallets(addresses: List<String>)

    @Delete
    suspend fun dropUserWallets()
}