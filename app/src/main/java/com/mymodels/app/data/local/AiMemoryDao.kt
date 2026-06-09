package com.mymodels.app.data.local

import androidx.room.*
import com.mymodels.app.data.model.AiMemory
import kotlinx.coroutines.flow.Flow

@Dao
interface AiMemoryDao {
    @Query("SELECT * FROM ai_memories WHERE userId = :userId AND modelId = :modelId AND isActive = 1 ORDER BY importance DESC, updatedAt DESC")
    fun getMemoriesForModel(userId: String, modelId: String): Flow<List<AiMemory>>

    @Query("SELECT * FROM ai_memories WHERE userId = :userId AND isActive = 1 ORDER BY updatedAt DESC")
    fun getAllMemoriesForUser(userId: String): Flow<List<AiMemory>>

    @Query("SELECT * FROM ai_memories WHERE userId = :userId AND category = :category AND isActive = 1")
    fun getMemoriesByCategory(userId: String, category: String): Flow<List<AiMemory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemory(memory: AiMemory): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemories(memories: List<AiMemory>)

    @Update
    suspend fun updateMemory(memory: AiMemory)

    @Query("UPDATE ai_memories SET isActive = 0 WHERE id = :id")
    suspend fun softDeleteMemory(id: Long)

    @Query("DELETE FROM ai_memories WHERE userId = :userId AND modelId = :modelId")
    suspend fun deleteMemoriesForModel(userId: String, modelId: String)

    @Query("DELETE FROM ai_memories WHERE userId = :userId")
    suspend fun deleteAllMemoriesForUser(userId: String)

    @Query("SELECT COUNT(*) FROM ai_memories WHERE userId = :userId AND modelId = :modelId AND isActive = 1")
    suspend fun countMemoriesForModel(userId: String, modelId: String): Int
}