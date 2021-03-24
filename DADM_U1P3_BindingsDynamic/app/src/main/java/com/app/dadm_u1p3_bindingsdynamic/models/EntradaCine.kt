package com.app.dadm_u1p3_bindingsdynamic.models

import android.os.Parcel
import android.os.Parcelable

data class EntradaCine(val pelicula: String,
                       val sala: String,
                       val horario: String,
                       val nBoletos: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pelicula) ?: ""
        parcel.writeString(sala) ?: ""
        parcel.writeString(horario) ?: ""
        parcel.writeString(nBoletos) ?: ""
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EntradaCine> {
        override fun createFromParcel(parcel: Parcel): EntradaCine {
            return EntradaCine(parcel)
        }

        override fun newArray(size: Int): Array<EntradaCine?> {
            return arrayOfNulls(size)
        }
    }
}
