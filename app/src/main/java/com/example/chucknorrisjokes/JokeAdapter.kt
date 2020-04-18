package com.example.chucknorrisjokes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    var jokeList: List<Joke> = emptyList()
        set(list: List<Joke>) {
            field = list
            notifyDataSetChanged()
        }


    class JokeViewHolder(val text: TextView) : RecyclerView.ViewHolder(text)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        //val tv: TextView = TextView(parent.context)
        val tv: TextView = LayoutInflater.from(parent.context).inflate(
            R.layout.text_view,
            parent,
            false
        ) as TextView
        return JokeViewHolder(tv)
    }

    override fun getItemCount() = jokeList.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.text.text = jokeList[position].value
    }

    fun setter(list: List<Joke>) {
        jokeList = list
    }

    fun onBottomReached() {

    }
}