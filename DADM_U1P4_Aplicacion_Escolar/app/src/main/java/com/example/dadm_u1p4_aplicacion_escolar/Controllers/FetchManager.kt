package com.example.dadm_u1p4_aplicacion_escolar.Controllers

import AvanceReticularQuery
import FindGroupByKeyQuery
import ReticulaQuery
import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import java.util.*

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

    /*fun AddGroupMutation(id_alumno: UUID,
                         id_grupo: Int,
                         estado: String,
                         semestre_cursada: Int,
                         calificacion: Int,
                         regularizacion: String,
                         evaluacion: String,
                         observaciones: String): Mutation<Any, Any, Any> {
        apolloClient.mutate(AddGroupMutation(id_alumno,id_grupo,estado,semestre_cursada,calificacion,regularizacion,evaluacion,observaciones)) }*/

    fun getGroupsByKey(clave: String): Flow<Response<FindGroupByKeyQuery.Data>> = apolloClient.query(FindGroupByKeyQuery(clave)).toFlow()

}