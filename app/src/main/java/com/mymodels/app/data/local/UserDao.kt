package com.mymodels.app.data.local

import androidx.room.*
import com.mymodels.app.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE firebaseUid = :uid LIMIT 1")
    fun getUserByFirebaseUid(uid: String): Flow<User?>

    @Query("SELECT * FROM users LIMIT 1")
    fun getCurrentUser(): Flow<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: String): User?
}