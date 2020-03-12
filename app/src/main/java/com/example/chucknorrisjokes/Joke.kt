package com.example.chucknorrisjokes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Joke(
    val categories: List<String>,
    @SerialName("created_At")
    val createdAt: String,
    @SerialName("icon_URL")
    val iconUrl: String,
    val id: String,
    @SerialName("updated_At")
    val updatedAt: String,
    val url: String,
    val value: String
)