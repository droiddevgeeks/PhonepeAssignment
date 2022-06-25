package com.example.phonepeassignment.helper

import com.example.domainmodule.models.IPopularMovies

fun IPopularMovies.mapToMovie(): MovieItem {
    return MovieItem(
        originalTitle = this.originalTitle,
        overview = this.overview,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.originalTitle,
        popularity = this.popularity,
        id = this.id,
        voteAverage = this.voteAverage,
    )
}