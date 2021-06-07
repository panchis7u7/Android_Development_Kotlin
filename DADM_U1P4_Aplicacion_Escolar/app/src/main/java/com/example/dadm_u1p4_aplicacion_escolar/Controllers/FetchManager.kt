package com.example.dadm_u1p4_aplicacion_escolar.Controllers

import AvanceReticularQuery
import FindGroupByKeyQuery
import ReticulaQuery
import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient

class FetchManager(val context: Context) {
    private val graphqlEndpoint: String = "http://192.168.1.133:9090/graphql"
    private var apolloClient: ApolloClient

    init {
        apolloClient = ApolloClient.builder()
            .serverUrl(graphqlEndpoint)
            .okHttpClient(OkHttpClient.Builder()
                .addInterceptor(AuthorizationInterceptor(context))
                .build()
            ).build()
    }

    fun getReticula(): Flow<Response<ReticulaQuery.Data>> = apolloClient.query(ReticulaQuery()).toFlow()
    fun getMaterias(): Flow<Response<AvanceReticularQuery.Data>> = apolloClient.query(AvanceReticularQuery(
        Alumno.id.toString())).toFlow()
    fun getGroupsByKey(clave: String): Flow<Response<FindGroupByKeyQuery.Data>> = apolloClient.query(FindGroupByKeyQuery(clave)).toFlow()

}