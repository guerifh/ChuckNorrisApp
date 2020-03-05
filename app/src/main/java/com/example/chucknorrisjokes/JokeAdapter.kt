package com.example.chucknorrisjokes

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    var jokeList = jokes.list

    class JokeViewHolder(val text: TextView) : RecyclerView.ViewHolder(text)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val tv: TextView = TextView(parent.context)
        return JokeViewHolder(tv)
    }

    override fun getItemCount() = jokeList.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.text.text = jokeList[position]
    }

    fun setter(list: List<String>) {
        jokeList = list
    }

}