package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.business.IGruposAlumnosBusiness
import com.scholar.SGE.model.GruposAlumnos
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.URL_GRUPOS_ALUMNOS)
class GruposAlumnosController {

    @Autowired
    val gruposAlumnosBusiness: IGruposAlumnosBusiness? = null

    @PostMapping("")
    fun insert(@RequestBody grupoAlumno: GruposAlumnos): ResponseEntity<Any> {
        return try {
            gruposAlumnosBusiness!!.addGroup(
                grupoAlumno.gruposAlumnosIdentity.id_alumno,
                grupoAlumno.gruposAlumnosIdentity.id_grupo,
                grupoAlumno.gruposAlumnosIdentity.estado,
                grupoAlumno.semestre_cursada!!,
                grupoAlumno.calificacion!!,
                grupoAlumno.regularizacion!!,
                grupoAlumno.evaluacion!!,
                grupoAlumno.observaciones!!
            )
            ResponseEntity(HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}