package com.example.dadm_u1p4_aplicacion_escolar.Interfaces

import com.example.dadm_u1p4_aplicacion_escolar.Models.MateriaGrupos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    //@Headers("Content-Type: text/html")
    //@Headers("Content-Type: application/json")
    @GET("/grupos")
    fun getGrupos(): Call<List<MateriaGrupos>>

    @Headers("Content-Type: application/json")
    @POST("/graphql")
    fun getGrupos(@Body body: String): Call<List<MateriaGrupos>>
}