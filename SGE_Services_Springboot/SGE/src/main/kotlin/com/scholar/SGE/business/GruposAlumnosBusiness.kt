package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.dao.GruposAlumnosRepository
import com.scholar.SGE.model.GruposAlumnos
import com.scholar.SGE.model.GruposAlumnosIdentity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GruposAlumnosBusiness: GraphQLMutationResolver, IGruposAlumnosBusiness {

    @Autowired
    val gruposAlumnosRepository: GruposAlumnosRepository? = null

    @Throws(BusinessException::class)
    override fun addGroup(
        id_alumno: UUID,
        id_grupo: Long,
        estado: String,
        semestre_cursada: Int,
        calificacion: Int,
        regularizacion: String,
        evaluacion: String,
        observaciones: String
    ): Boolean {
        try {
            val grupo = GruposAlumnos(GruposAlumnosIdentity(id_alumno, id_grupo, estado),
                    semestre_cursada, calificacion, regularizacion, evaluacion, observaciones, null, null)
            gruposAlumnosRepository!!.save(grupo)
            return true
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }
}