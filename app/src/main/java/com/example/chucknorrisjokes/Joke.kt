package com.example.chucknorrisjokes

import android.util.Log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Joke(
    val categories: List<String>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("icon_url")
    val iconUrl: String,
    val id: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val url: String,
    val value: String
) {
    override fun equals(other: Any?): Boolean {
        var bool = true
        val param: Joke
        try {
            param = other as Joke
        } catch (Error: Exception) {
            Log.d("Erreur de cast", Error.toString())
            return false
        }
        if (categories != param.categories || createdAt != param.createdAt || iconUrl != param.iconUrl || id != param.id || updatedAt != param.updatedAt || url != param.url || value != param.value) {
            bool = false
        }
        return bool
    }
}