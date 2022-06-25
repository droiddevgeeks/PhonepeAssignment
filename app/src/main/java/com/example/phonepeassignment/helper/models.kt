package com.example.phonepeassignment.helper

import com.example.domainmodule.common.IFailure
import com.example.domainmodule.models.IPopularMovies
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ApiState<out T> {
    data class Loading(val isLoading: Boolean) : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Failure(val failure: IFailure) : ApiState<Nothing>()
}


@Parcelize
class MovieItem(
    override val originalTitle: String,
    override val overview: String,
    override val posterPath: String,
    override val releaseDate: String,
    override val title: String,
    override val popularity: Float,
    override val id: Int,
    override val voteAverage: Float,
) : IPopularMovies, Parcelable