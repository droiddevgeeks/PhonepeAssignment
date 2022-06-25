package com.example.datamodule.network

import com.example.datamodule.models.PopularMovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConstants.POPULAR_MOVIES)
    suspend fun getPopularMovies(): PopularMovieResponse
}