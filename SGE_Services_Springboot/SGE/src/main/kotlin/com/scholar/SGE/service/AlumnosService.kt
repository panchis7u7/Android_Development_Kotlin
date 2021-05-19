package com.scholar.SGE.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.datasource.AlumnosDataSource
import com.scholar.SGE.model.Alumno
import com.sun.el.stream.Optional

@Service
class AlumnosService(): IAlumnosBusiness {

    @Autowired
    val alumnoDataSource: AlumnosDataSource? = null

    /*fun getAlumnos(): Collection<Alumno> = dataSource.obtenerAlumnos()*/

    override fun list(): List<Alumno> {
        return alumnoDataSource!!.findAll()
    }

    override fun load(idAlumno: Int): Alumno {
       val op = alumnoDataSource!!.findById(idAlumno)
       return op.get()
    }

    override fun save(alumno: Alumno): Alumno {
        return alumnoDataSource!!.save(alumno)
    }

    override fun remove(idAlumno: Int) {
        val op = alumnoDataSource!!.findById(idAlumno)
        alumnoDataSource!!.deleteById(idAlumno)
    }
}