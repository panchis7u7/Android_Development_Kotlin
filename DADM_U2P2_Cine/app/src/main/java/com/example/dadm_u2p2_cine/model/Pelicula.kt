package com.example.dadm_u2p2_cine.model

import android.os.Parcel
import android.os.Parcelable

data class Pelicula(val titulo: String? = "",
                    val imagen: String? = "",
                    val cover: String? = "",
                    val rating: Float? = 0f): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(imagen)
        parcel.writeString(cover)
        parcel.writeValue(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }
}