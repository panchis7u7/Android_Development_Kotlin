package com.example.dadm_u1p4_aplicacion_escolar.Controllers

import com.example.dadm_u1p4_aplicacion_escolar.Interfaces.Api
import com.example.dadm_u1p4_aplicacion_escolar.Models.MateriaGrupos
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class FetchManager(JWTToken: String) {
    private var _retrofit: Api? = null
    private val retrofit get() = _retrofit!!
    private lateinit var client: OkHttpClient
    private val baseUrl: String = "http://192.168.1.133:9090/"
    init {
        client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $JWTToken")
                .build()
            chain.proceed(newRequest)
        }.build()

        _retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun getGrupos(): List<MateriaGrupos>?{
        val paramObject = JSONObject()
        val query =
        paramObject.put("query",
        """
        query {
                listAsignaturas {
                    asignatura
                    clave
                    grupos {
                        grupo
                        horario_lunes
                        horario_martes
                        horario_miercoles
                        horario_jueves
                        horario_viernes
                        aula_lunes
                        aula_martes
                        aula_miercoles
                        aula_jueves
                        aula_viernes
                        profesor {
                            nombre
                        }
                    }
                }
            }
        """.trimIndent())
        val response = retrofit.getGrupos(query.toString()).awaitResponse()
        if(response.isSuccessful())
            return response.body()!!
        else return null
    }
}