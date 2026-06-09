package com.mymodels.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "hf_models")
data class HuggingFaceModel(
    @PrimaryKey
    val modelId: String = "",
    val author: String = "",
    val modelName: String = "",
    val pipeline: String = "",
    val downloads: Int = 0,
    val likes: Int = 0,
    val isPrivate: Boolean = false,
    val lastModified: String = "",
    val tags: String = "",
    val isFavorited: Boolean = false,
    val addedAt: Long = System.currentTimeMillis()
)

@Serializable
data class HuggingFaceSearchResponse(
    @SerialName("modelId") val modelId: String = "",
    @SerialName("author") val author: String? = null,
    @SerialName("id") val id: String = "",
    @SerialName("pipeline_tag") val pipelineTag: String? = null,
    @SerialName("downloads") val downloads: Int = 0,
    @SerialName("likes") val likes: Int = 0,
    @SerialName("private") val isPrivate: Boolean = false,
    @SerialName("lastModified") val lastModified: String = "",
    @SerialName("tags") val tags: List<String> = emptyList()
)

@Serializable
data class HuggingFaceChatRequest(
    @SerialName("model") val model: String,
    @SerialName("messages") val messages: List<HuggingFaceMessage>,
    @SerialName("max_tokens") val maxTokens: Int = 1024,
    @SerialName("temperature") val temperature: Float = 0.7f,
    @SerialName("stream") val stream: Boolean = false
)

@Serializable
data class HuggingFaceMessage(
    @SerialName("role") val role: String,
    @SerialName("content") val content: String
)

@Serializable
data class HuggingFaceChatResponse(
    @SerialName("choices") val choices: List<HuggingFaceChoice> = emptyList(),
    @SerialName("usage") val usage: HuggingFaceUsage? = null
)

@Serializable
data class HuggingFaceChoice(
    @SerialName("message") val message: HuggingFaceMessage = HuggingFaceMessage("", ""),
    @SerialName("finish_reason") val finishReason: String = ""
)

@Serializable
data class HuggingFaceUsage(
    @SerialName("prompt_tokens") val promptTokens: Int = 0,
    @SerialName("completion_tokens") val completionTokens: Int = 0,
    @SerialName("total_tokens") val totalTokens: Int = 0
)