package com.example.dadm_u1p4_aplicacion_escolar.Controllers

import AvanceReticularQuery
import ReticulaQuery
import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient

class FetchManager(val context: Context) {
    private lateinit var client: OkHttpClient
    private val graphqlEndpoint: String = "http://192.168.1.133:9090/graphql"
    var apolloClient: ApolloClient

    init {
        apolloClient = ApolloClient.builder()
            .serverUrl(graphqlEndpoint)
            .okHttpClient(OkHttpClient.Builder()
                .addInterceptor(AuthorizationInterceptor(context))
                .build()
            ).build()

        /*client = OkHttpClient.Builder().addInterceptor { chain ->
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
            .create(Api::class.java)*/
    }

    fun getReticula(): Flow<Response<ReticulaQuery.Data>> = apolloClient.query(ReticulaQuery()).toFlow()
    fun getMaterias(): Flow<Response<AvanceReticularQuery.Data>> = apolloClient.query(AvanceReticularQuery(
        Alumno.id.toString())).toFlow()

}