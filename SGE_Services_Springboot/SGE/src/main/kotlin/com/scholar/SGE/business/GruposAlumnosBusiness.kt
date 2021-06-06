package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.dao.GruposAlumnosRepository
import com.scholar.SGE.model.GruposAlumnos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GruposAlumnosBusiness: GraphQLQueryResolver, IGruposAlumnosBusiness {

    @Autowired
    val gruposAlumnosRepository: GruposAlumnosRepository? = null

    @Throws(BusinessException::class)
    override fun saveGrupoAlumno(gruposAlumnos: GruposAlumnos): GruposAlumnos {
        try {
            return gruposAlumnosRepository!!.save(gruposAlumnos)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }
}