package com.example.datamodule.models

import com.google.gson.annotations.SerializedName


data class PopularMovieResponse(
    @SerializedName("results")
    val results: List<PopularMovies>
)

data class PopularMovies(
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("popularity")
    val popularity: Float,
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Float
)