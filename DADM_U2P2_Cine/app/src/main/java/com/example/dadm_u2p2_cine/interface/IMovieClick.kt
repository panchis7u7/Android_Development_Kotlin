package com.example.dadm_u2p2_cine.`interface`

import com.example.dadm_u2p2_cine.model.Pelicula

interface IMovieClick {
    fun onItemClick(pelicula: Pelicula)
}