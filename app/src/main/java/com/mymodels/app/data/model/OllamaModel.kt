package com.mymodels.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ollama_models")
data class OllamaModel(
    @PrimaryKey
    val name: String = "",
    val model: String = "",
    val modifiedAt: String = "",
    val size: Long = 0L,
    val digest: String = "",
    val isDownloaded: Boolean = false,
    val isActive: Boolean = false
)

@Serializable
data class OllamaModelDetails(
    @SerialName("parent_model") val parentModel: String = "",
    @SerialName("format") val format: String = "",
    @SerialName("family") val family: String = "",
    @SerialName("families") val families: List<String> = emptyList(),
    @SerialName("parameter_size") val parameterSize: String = "",
    @SerialName("quantization_level") val quantizationLevel: String = ""
)

@Serializable
data class OllamaListResponse(
    @SerialName("models") val models: List<OllamaModelItem> = emptyList()
)

@Serializable
data class OllamaModelItem(
    @SerialName("name") val name: String = "",
    @SerialName("model") val model: String = "",
    @SerialName("modified_at") val modifiedAt: String = "",
    @SerialName("size") val size: Long = 0L,
    @SerialName("digest") val digest: String = "",
    @SerialName("details") val details: OllamaModelDetails? = null
)

@Serializable
data class OllamaChatRequest(
    @SerialName("model") val model: String,
    @SerialName("messages") val messages: List<OllamaChatMessage>,
    @SerialName("stream") val stream: Boolean = false,
    @SerialName("options") val options: OllamaOptions? = null
)

@Serializable
data class OllamaChatMessage(
    @SerialName("role") val role: String,
    @SerialName("content") val content: String
)

@Serializable
data class OllamaOptions(
    @SerialName("temperature") val temperature: Float? = null,
    @SerialName("top_p") val topP: Float? = null,
    @SerialName("num_ctx") val numCtx: Int? = null
)

@Serializable
data class OllamaChatResponse(
    @SerialName("model") val model: String = "",
    @SerialName("message") val message: OllamaChatMessage = OllamaChatMessage("", ""),
    @SerialName("done") val done: Boolean = false,
    @SerialName("total_duration") val totalDuration: Long = 0L,
    @SerialName("eval_count") val evalCount: Int = 0
)