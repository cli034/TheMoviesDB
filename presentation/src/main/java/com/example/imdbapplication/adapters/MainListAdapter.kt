package com.example.imdbapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.imdbapplication.R
import com.example.imdbapplication.databinding.ItemMovieBinding

class MainListAdapter(): ListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        if (holder is MovieViewHolder) {
            holder.binding.itemMovieTitleTextView.text = movie.title
            holder.binding.itemMovieVoteCountValueTextView.text = movie.vote_count.toString()
            holder.binding.itemMovieOverViewTextView.text = movie.overview
        }
    }

    inner class MovieViewHolder(itemMovieBinding: ItemMovieBinding): RecyclerView.ViewHolder(itemMovieBinding.root) {
        val binding = itemMovieBinding
    }
}