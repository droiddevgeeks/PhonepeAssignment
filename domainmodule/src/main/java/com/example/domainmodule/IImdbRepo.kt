package com.example.domainmodule

import com.example.domainmodule.common.IFailure
import com.example.domainmodule.models.IPopularMovies
import com.example.domainmodule.common.Result

interface IImdbRepo {
    suspend fun getPopularMovies(): Result<IFailure, List<IPopularMovies>>
}