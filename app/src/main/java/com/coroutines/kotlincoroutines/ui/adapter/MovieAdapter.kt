package com.coroutines.kotlincoroutines.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.coroutines.kotlincoroutines.R
import com.coroutines.kotlincoroutines.data.model.MovieItem
import com.coroutines.kotlincoroutines.databinding.MovieAdapterBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movieList = mutableListOf<MovieItem>()
    lateinit var binding:MovieAdapterBinding

    fun setMovie(movies:List<MovieItem>){
        this.movieList = movies.toMutableList()
        println("fffffffff")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        binding= DataBindingUtil.inflate<MovieAdapterBinding>(inflater,
            R.layout.movie_adapter,
            parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        binding.movie = movieList[position]
        println("data ___"+movieList[position].name)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    inner class MovieViewHolder(itemView: MovieAdapterBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
}