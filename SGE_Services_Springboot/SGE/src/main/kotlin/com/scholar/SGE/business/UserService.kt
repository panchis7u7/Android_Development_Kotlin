package com.scholar.SGE.business

import com.scholar.SGE.exception.AuthException
import com.scholar.SGE.model.Alumno

interface UserService {
    @Throws(AuthException::class)
    fun validateUser(email: String, password: String)
    fun registerUser(alumno: Alumno): Alumno
}