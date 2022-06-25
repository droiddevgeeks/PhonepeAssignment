package com.example.domainmodule.usecases

import com.example.domainmodule.IImdbRepo
import com.example.domainmodule.common.IFailure
import com.example.domainmodule.common.UseCase
import com.example.domainmodule.models.IPopularMovies
import com.example.domainmodule.common.Result
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repo: IImdbRepo
) : UseCase<Unit, List<IPopularMovies>>() {

    override suspend fun run(params: Unit): Result<IFailure, List<IPopularMovies>> {
        return repo.getPopularMovies()
    }
}