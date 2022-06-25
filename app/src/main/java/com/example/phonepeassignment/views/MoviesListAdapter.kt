package com.example.phonepeassignment.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datamodule.network.ApiConstants.IMAGE_BASE_URL
import com.example.domainmodule.models.IPopularMovies
import com.example.phonepeassignment.databinding.MovieItemRowBinding
import com.example.phonepeassignment.helper.loadImage

class MoviesListAdapter(val onClick: (IPopularMovies) -> Unit) :
    RecyclerView.Adapter<MoviesListAdapter.ItemViewHolder>() {

    private val moviesList: MutableList<IPopularMovies> by lazy { mutableListOf() }

    internal fun updateData(list: List<IPopularMovies>) {
        this.moviesList.clear()
        this.moviesList.addAll(list)
        //TODO replace with Diff util
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val dataBinding = MovieItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class ItemViewHolder(private var itemBinding: MovieItemRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: IPopularMovies) {
            itemBinding.movie = movie
            itemBinding.movieImage.loadImage(IMAGE_BASE_URL + movie.posterPath)
            itemBinding.root.setOnClickListener {
                onClick.invoke(movie)
            }
        }
    }
}