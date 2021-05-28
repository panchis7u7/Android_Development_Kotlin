package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.model.Alumno
import com.scholar.SGE.dao.AlumnoRepository
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.model.AlumnoGraphQL
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import java.time.LocalDate
import java.util.*

@Service
class AlumnoBusiness: GraphQLQueryResolver, GraphQLMutationResolver,IAlumnoBusiness{

    companion object {
        //private var factory: SessionFactory? = null
    }
    @Autowired
    val alumnoRepository: AlumnoRepository? = null

    /*init {
        try {
            factory = Configuration().configure().buildSessionFactory()
        } catch (e: ExceptionInInitializerError) {
            throw ExceptionInInitializerError(e.message)
            print("Failed to create a sessionFactory Object: ${e.message}")
        }
    }*/

    @Throws(BusinessException::class)
    override fun listAlumnos(): List<Alumno>{
        try{
            return alumnoRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadAlumno(idAlumno: String): Alumno{
        val optional: Optional<Alumno>
        try{
            optional = alumnoRepository!!.findById(UUID.fromString(idAlumno))
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el alumno con id $idAlumno!")
        
        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveAlumno(alumno: Alumno): Alumno{
        //var session = factory?.openSession()
        //var tx: Transaction? = null

        try {
            //tx = session?.beginTransaction()
            return alumnoRepository!!.save(alumno)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun saveAlumnoQL(alumno: AlumnoGraphQL): Alumno {
        try {
            print(alumno)
            return alumnoRepository!!.save(Alumno(
                alumno.id_alumno,
                alumno.no_control,
                alumno.correo,
                alumno.curp,
                alumno.nombre,
                LocalDate.parse(alumno.fecha_nacimiento),
                alumno.telefono,
                alumno.sexo,
                alumno.fotografia,
                alumno.domicilio
            ))
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeAlumno(idAlumno: String){
        val optional: Optional<Alumno>
        try {
            optional = alumnoRepository!!.findById(UUID.fromString(idAlumno))
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el alumno con id $idAlumno!")
        else{
            try {
            alumnoRepository!!.deleteById(UUID.fromString(idAlumno))
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}

/*
mutation {
  saveAlumno(input: {nombre: "Prueba", no_control:"18121700", correo:"sebastian.mad@gmail.com", curp:"prueba", fecha_nacimiento:"1999-07-14", telefono: "4434548761", sexo: "M", fotografia:"prueba1"}){
    id_alumno
    no_control
    correo
    curp
    nombre
    fecha_nacimiento
    telefono
    sexo
    fotografia
  }
}
 */