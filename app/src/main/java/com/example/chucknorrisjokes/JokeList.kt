package com.example.chucknorrisjokes

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object jokes {
    val list =
        listOf<String>(
            "Chuck Norris was recently asked what he thought of Nancy Pelosi? Chuck said he thinks Nancy Pelosi is uglier than a bucket of buttholes. There were no further questions.",
            "Once Chuck Norris peed against a fence. A police officer saw him and said - That's against the law! - No, said Chuck. It is against the fence!",
            "On Day Zero, Chuck Norris created God.",
            "Chuckeroo = Chuck Norris spam.",
            "If it looks like chicken, tastes like chicken, and feels like chicken but Chuck Norris says its beef, then it's fucking beef.",
            "Chuck Norris doesn't drink often. But when he does, he prefers to kick 'the most interesting man in the word' in the ass & take his Dos Equis.",
            "Why is Phillip's head shaped like a screwdriver? Chuck Norris.",
            "Chuck Norris eats Spicy Chicken Crunchwraps, made with live chickens.",
            "When Chuck Norris brews a strong pot of coffee he uses a flame thrower and 1/2 of Columbia's coffee trees.",
            "Chuck Norris is the way the cookie crumbles.",
            "Chuck Norris doesn't laugh in the face of danger. He punches it repeatedly until it's the face of fear.",
            "Chuck Norris' father is Chuck Norris, his mother is America, his brother is freedom and his other brother is Sam... Sam Norris. Chuck Norris loves his family dearly, except for Sam, that is why Sam no longer exists."
        )
//Log.d("Liste", list.toString())

}

object jokeApiServiceFactory {

    fun jokeService(): JokeApiService {
        val url: String = "https://api.chucknorris.io/jokes/random"
        val fact = Json.asConverterFactory(MediaType.get("application/json"))
        val requestInterface = Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(fact.create())
            .build().create(RequestInterface::class.java)
    }

}