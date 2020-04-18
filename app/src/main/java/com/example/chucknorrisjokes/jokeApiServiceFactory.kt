package com.example.chucknorrisjokes

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.create

object JokeApiServiceFactory {
    fun jokeService(): JokeApiService {

        val requestInterface = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/random/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()

        return requestInterface.create()
    }
}