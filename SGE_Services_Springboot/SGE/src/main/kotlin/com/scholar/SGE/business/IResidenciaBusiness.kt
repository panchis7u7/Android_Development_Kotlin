package com.scholar.SGE.business

import com.scholar.SGE.model.Colonia
import com.scholar.SGE.model.Estado
import com.scholar.SGE.model.Municipio
import com.scholar.SGE.model.Residencia

interface IResidenciaBusiness {
    fun listResidencias(): List<Residencia>
    fun loadResidencia(idResidencia: Long): Residencia
    fun saveResidencia(Residencia: Residencia): Residencia
    fun removeResidencia(idResidencia: Long)

    fun listColonias(): List<Colonia>
    fun listMunicipios(): List<Municipio>
    fun listEstados(): List<Estado>
}