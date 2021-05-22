package com.example.dadm_u2p2_cine.model

import android.os.Parcel
import android.os.Parcelable

data class Pelicula(val titulo: String? = "",
                    val imagen: String? = "",
                    val cover: String? = "",
                    val rating: Float? = 0f,
                    val director: String? ="",
                    val duracion: String? = "",
                    val genero: String? = "",
                    val sinopsis: String? = "",
                    val fechas: Array<Array<String>>? = null) {
}