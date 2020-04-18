package com.example.chucknorrisjokes

import io.reactivex.Single
import retrofit2.http.GET


interface JokeApiService {

    @GET("https://api.chucknorris.io/jokes/random/")
    fun giveMeaJoke(): Single<Joke>

}