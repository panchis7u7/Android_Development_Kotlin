package com.example.dadm_u2p2_cine.model

data class Compra(val pelicula: Pelicula,
                  val total: Float,
                  val hora: String,
                  val asientos: String) {
}