package com.example.dadm_u2p2_cine.model

data class Compra(val pelicula: Pelicula,
                  val total: Float,
                  val fecha: String,
                  val hora: String,
                  val noAsientos: Int,
                  val asientos: String,
                  val departamento: String) {
}