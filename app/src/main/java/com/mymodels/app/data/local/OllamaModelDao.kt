package com.mymodels.app.data.local

import androidx.room.*
import com.mymodels.app.data.model.OllamaModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OllamaModelDao {
    @Query("SELECT * FROM ollama_models ORDER BY name ASC")
    fun getAllModels(): Flow<List<OllamaModel>>

    @Query("SELECT * FROM ollama_models WHERE isDownloaded = 1 ORDER BY name ASC")
    fun getDownloadedModels(): Flow<List<OllamaModel>>

    @Query("SELECT * FROM ollama_models WHERE isActive = 1 LIMIT 1")
    fun getActiveModel(): Flow<OllamaModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModel(model: OllamaModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(models: List<OllamaModel>)

    @Update
    suspend fun updateModel(model: OllamaModel)

    @Query("DELETE FROM ollama_models WHERE name = :name")
    suspend fun deleteModel(name: String)

    @Query("UPDATE ollama_models SET isActive = 0")
    suspend fun deactivateAllModels()

    @Query("UPDATE ollama_models SET isActive = 1 WHERE name = :name")
    suspend fun activateModel(name: String)
}