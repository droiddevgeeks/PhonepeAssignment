package com.example.datamodule.repo

import com.example.datamodule.network.ApiService
import com.example.datamodule.network.apiCall
import com.example.domainmodule.IImdbRepo
import com.example.domainmodule.common.IFailure
import com.example.domainmodule.common.Result
import com.example.domainmodule.models.IPopularMovies
import javax.inject.Inject

class ImdbRepo @Inject constructor(
    private val apiService: ApiService
) : IImdbRepo {

    override suspend fun getPopularMovies(): Result<IFailure, List<IPopularMovies>> {
        return apiCall(
            apiCall = { apiService.getPopularMovies() },
            successTransform = { it.toPopularMovieData() }
        )
    }
}