package com.example.phonepeassignment.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.datamodule.network.ApiConstants
import com.example.domainmodule.models.IPopularMovies
import com.example.phonepeassignment.databinding.MovieDetailLayoutBinding
import com.example.phonepeassignment.helper.MovieItem
import com.example.phonepeassignment.helper.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    companion object {
        private const val DATA_KEY = "DetailFragment"
        fun getInstance(movie: MovieItem): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply { putParcelable(DATA_KEY, movie) }
            }
        }
    }

    private var binding: MovieDetailLayoutBinding? = null
    private var movie: IPopularMovies? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailLayoutBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
        setDataInUI()
    }

    private fun initArgs() {
        movie = arguments?.getParcelable(DATA_KEY)
    }


    private fun setDataInUI() {
        movie?.let { movie ->
            binding?.let {
                it.movie = movie
                /*it.movieRelease.text = movie.releaseDate
                it.moviePopularity.text = movie.popularity.toString()
                it.movieRating.text = movie.voteAverage.toString()
                it.movieOverview.text = movie.overview*/
                it.movieImage.loadImage(ApiConstants.IMAGE_BASE_URL + movie.posterPath)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}