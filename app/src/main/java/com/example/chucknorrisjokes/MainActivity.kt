package com.example.chucknorrisjokes

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var view: RecyclerView
    lateinit var viewManager: LinearLayoutManager
    private val composite = CompositeDisposable()
    private var jokesStored: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        val viewAdapter = JokeAdapter()
        view = findViewById(R.id.main_RecyclerView)

        view.apply {
            setHasFixedSize(true)
            adapter = viewAdapter
            layoutManager = viewManager
        }


        val loader = findViewById<ProgressBar>(R.id.joke_loader)


        fun display10Jokes(viewAdapter: JokeAdapter) {
            val joke = JokeApiServiceFactory.jokeService().giveMeaJoke()
            val temp = joke
                .repeat(10)
                .delay(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { loader.visibility = View.VISIBLE }
                .doOnComplete { loader.visibility = View.INVISIBLE }
                .subscribeBy(
                    onError = { Log.d("Error", it.toString()) },
                    onNext = { viewAdapter.jokeList = viewAdapter.jokeList.plus(it) }
                )
            composite.add(temp)
        }

        display10Jokes(viewAdapter)
        view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if ((viewManager as LinearLayoutManager).findLastVisibleItemPosition() == viewAdapter.itemCount - 1 && !jokesStored) {
                    display10Jokes(viewAdapter)
                }

            }
        })

    }

    override fun onSaveInstanceState(SavedInstantState: Bundle) {
        super.onSaveInstanceState(SavedInstantState)

        jokesStored = true
        SavedInstantState.putString(
            "joke_key",
            JokeApiServiceFactory.jokeService().giveMeaJoke().toString()
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val jk = savedInstanceState.getString("joke_key")

        jokesStored = false
    }

}