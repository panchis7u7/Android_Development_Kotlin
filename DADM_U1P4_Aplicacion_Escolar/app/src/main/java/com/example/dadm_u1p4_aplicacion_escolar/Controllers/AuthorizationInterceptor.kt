package com.example.dadm_u1p4_aplicacion_escolar.Controllers

import android.content.Context
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + Alumno.token)
            .build()

        return chain.proceed(request)
    }
}