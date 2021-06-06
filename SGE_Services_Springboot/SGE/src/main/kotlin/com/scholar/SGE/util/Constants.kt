package com.scholar.SGE.util

class Constants {
    companion object {
        private const val URL_BASE_API = "/"

        const val API_SECRET_KEY = "sGeScHoLaRaPiKey"
        const val TOKEN_VALIDITY = 2 * 60 * 60 * 1000   //2Hrs in milliseconds.

        const val URL_ALUMNOS = "$URL_BASE_API/alumnos"
        const val URL_PROFESORES = "$URL_BASE_API/profesores"
        const val URL_ASIGNATURAS = "$URL_BASE_API/asignaturas"
        const val URL_DOMICILIOS = "$URL_BASE_API/domicilios"
        const val URL_GRUPOS = "$URL_BASE_API/grupos"
        const val URL_GRUPOS_ALUMNOS = "$URL_BASE_API/gruposAlumnos"
    }
}