package com.scholar.SGE.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.scholar.SGE.service.AlumnosService
import com.scholar.SGE.model.Alumno

@RestController
@RequestMapping("alumnos")
class AlumnosController(private val service: AlumnosService){

    @GetMapping
    fun getAlumnos(): Collection<Alumno> = service.list()

}