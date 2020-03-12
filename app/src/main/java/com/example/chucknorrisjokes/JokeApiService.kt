package com.example.chucknorrisjokes

import io.reactivex.Single
import retrofit2.http.GET


interface JokeApiService {

    @GET("url_path_extension")
    fun giveMeaJoke(): Single<Joke>

}