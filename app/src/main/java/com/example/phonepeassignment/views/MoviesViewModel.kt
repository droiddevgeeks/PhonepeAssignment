package com.example.phonepeassignment.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domainmodule.models.IPopularMovies
import com.example.domainmodule.usecases.GetPopularMoviesUseCase
import com.example.phonepeassignment.helper.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _fetchPopularMovies: MutableLiveData<ApiState<List<IPopularMovies>>> by lazy { MutableLiveData() }
    val fetchPopularMovies: LiveData<ApiState<List<IPopularMovies>>> by lazy { _fetchPopularMovies }

    internal fun fetchPopularMovies() {
        _fetchPopularMovies.value = ApiState.Loading(true)
        useCase.invoke(
            scope = viewModelScope,
            params = Unit,
            onSuccess = {
                _fetchPopularMovies.value = ApiState.Loading(false)
                _fetchPopularMovies.value = ApiState.Success(it)
            },
            onFailure = { _fetchPopularMovies.value = ApiState.Failure(it) }
        )
    }
}