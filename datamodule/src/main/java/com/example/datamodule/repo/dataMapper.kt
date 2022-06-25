package com.example.datamodule.repo

import com.example.datamodule.models.PopularMovieResponse
import com.example.domainmodule.models.IPopularMovies

fun PopularMovieResponse.toPopularMovieData(): List<IPopularMovies> {
    val moviesList = mutableListOf<PopularMovieData>()
    this.results.forEach {
        moviesList.add(
            PopularMovieData(
                originalTitle = it.originalTitle,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                popularity = it.popularity,
                id = it.id,
                voteAverage = it.voteAverage
            )
        )
    }
    return moviesList
}
