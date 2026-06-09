package com.mymodels.app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubTokenResponse(
    @SerialName("access_token") val accessToken: String = "",
    @SerialName("token_type") val tokenType: String = "",
    @SerialName("scope") val scope: String = ""
)

@Serializable
data class GitHubUserResponse(
    @SerialName("id") val id: Long = 0,
    @SerialName("login") val login: String = "",
    @SerialName("name") val name: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("avatar_url") val avatarUrl: String = "",
    @SerialName("bio") val bio: String? = null,
    @SerialName("company") val company: String? = null,
    @SerialName("location") val location: String? = null,
    @SerialName("blog") val blog: String? = null,
    @SerialName("public_repos") val publicRepos: Int = 0,
    @SerialName("public_gists") val publicGists: Int = 0,
    @SerialName("followers") val followers: Int = 0,
    @SerialName("following") val following: Int = 0,
    @SerialName("html_url") val htmlUrl: String = "",
    @SerialName("created_at") val createdAt: String = "",
    @SerialName("updated_at") val updatedAt: String = "",
    @SerialName("node_id") val nodeId: String = "",
    @SerialName("twitter_username") val twitterUsername: String? = null
)