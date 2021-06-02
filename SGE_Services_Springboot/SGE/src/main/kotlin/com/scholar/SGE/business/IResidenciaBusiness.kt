package com.scholar.SGE.business

import com.scholar.SGE.model.Residencia

interface IResidenciaBusiness {
    fun listResidencias(): List<Residencia>
    fun loadResidencia(idResidencia: Long): Residencia
    fun saveResidencia(Residencia: Residencia): Residencia
    fun removeResidencia(idResidencia: Long)
}