package com.scholar.SGE.business

import com.scholar.SGE.model.Alumno
import com.scholar.SGE.model.AlumnoGraphQL
import com.scholar.SGE.model.Grupo

interface IGrupoBusiness {
    fun listGrupos(): List<Grupo>
    fun loadGrupo(idGrupo: Long): Grupo
    fun saveGrupo(grupo: Grupo): Grupo
    fun removeGrupo(idGrupo: Long)
}