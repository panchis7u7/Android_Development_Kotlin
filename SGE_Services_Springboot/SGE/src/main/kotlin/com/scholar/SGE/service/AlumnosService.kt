package com.scholar.SGE.service

import org.springframework.stereotype.Service
import com.scholar.SGE.datasource.AlumnosDataSource
import com.scholar.SGE.model.Alumnos

@Service
class AlumnosService(private val dataSource: AlumnosDataSource){
    fun getAlumnos(): Collection<Alumnos> = dataSource.obtenerAlumnos()
}