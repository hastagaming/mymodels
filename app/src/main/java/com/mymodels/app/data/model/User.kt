package com.mymodels.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String = "",
    val login: String = "",
    val name: String = "",
    val email: String? = null,
    val avatarUrl: String = "",
    val bio: String? = null,
    val company: String? = null,
    val location: String? = null,
    val blog: String? = null,
    val publicRepos: Int = 0,
    val publicGists: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,
    val htmlUrl: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    val nodeId: String = "",
    val twitterUsername: String? = null,
    val firebaseUid: String = "",
    val githubAccessToken: String = "",
    val lastLoginAt: Long = System.currentTimeMillis()
)