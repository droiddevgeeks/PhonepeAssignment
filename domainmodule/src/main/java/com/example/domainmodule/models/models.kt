package com.example.domainmodule.models

interface IPopularMovies {
    val originalTitle: String
    val overview: String
    val posterPath: String
    val releaseDate: String
    val title: String
    val popularity: Float
    val id: Int
    val voteAverage: Float
}