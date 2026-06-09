package com.mymodels.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mymodels.app.data.model.*

@Database(
    entities = [
        User::class,
        AiMemory::class,
        ChatSession::class,
        ChatMessage::class,
        OllamaModel::class,
        HuggingFaceModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun aiMemoryDao(): AiMemoryDao
    abstract fun chatDao(): ChatDao
    abstract fun ollamaModelDao(): OllamaModelDao
    abstract fun huggingFaceModelDao(): HuggingFaceModelDao
}