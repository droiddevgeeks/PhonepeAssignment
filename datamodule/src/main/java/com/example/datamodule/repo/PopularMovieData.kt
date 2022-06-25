package com.example.datamodule.repo

import com.example.domainmodule.models.IPopularMovies

data class PopularMovieData(
    override val originalTitle: String,
    override val overview: String,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val popularity: Float,
    override val id: Int,
    override val voteAverage: Float,
) : IPopularMovies
