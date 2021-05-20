package com.example.dadm_u2p2_cine.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dadm_u2p2_cine.model.Pelicula
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieStateFlow: ViewModel() {
    private val _movie = MutableStateFlow<LatestMovieState>(LatestMovieState.Empty)
    val movieState: StateFlow<LatestMovieState> = _movie

    fun setMovie(movie: Pelicula) = viewModelScope.launch {
        _movie.value = LatestMovieState.Success(movie)
    }

    sealed class LatestMovieState {
        data class Success(val movie: Pelicula): LatestMovieState()
        object Empty: LatestMovieState()
    }
}