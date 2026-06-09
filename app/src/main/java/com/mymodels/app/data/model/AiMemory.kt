package com.mymodels.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ai_memories")
data class AiMemory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: String = "",
    val modelId: String = "",
    val modelSource: String = "",
    val key: String = "",
    val value: String = "",
    val category: String = "general",
    val importance: Int = 1,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
)

@Serializable
@Entity(tableName = "chat_sessions")
data class ChatSession(
    @PrimaryKey
    val id: String = "",
    val userId: String = "",
    val modelId: String = "",
    val modelSource: String = "",
    val title: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true,
    val systemPrompt: String = ""
)

@Serializable
@Entity(tableName = "chat_messages")
data class ChatMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sessionId: String = "",
    val role: String = "",
    val content: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val tokenCount: Int = 0
)