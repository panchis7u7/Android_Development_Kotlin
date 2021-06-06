package com.scholar.SGE.business

import com.scholar.SGE.model.GruposAlumnos

interface IGruposAlumnosBusiness {
    fun saveGrupoAlumno(gruposAlumnos: GruposAlumnos): GruposAlumnos
}