package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.model.Alumno
import com.scholar.SGE.dao.AlumnoRepository
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.exception.AuthException
import com.scholar.SGE.model.AlumnoGraphQL
import com.scholar.SGE.model.Domicilio
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.postgresql.shaded.com.ongres.scram.common.util.CryptoUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDate
import java.util.*
import java.util.regex.Pattern

@Service
class AlumnoBusiness: GraphQLQueryResolver, GraphQLMutationResolver, IAlumnoBusiness{

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

    override fun validateUser(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun registerUser(alumno: AlumnoGraphQL): Alumno {
        var pattern = Pattern.compile("^(.+)@(.+)$")
        alumno.contrasena = BCryptPasswordEncoder().encode(alumno.contrasena)
        if (!pattern.matcher(alumno.correo).matches())
            throw AuthException("Formato de correo invalido!")
        val count = alumnoRepository!!.getCountByAlumnoCorreo(alumno.correo)
        if (count > 0)
            throw AuthException("Account alredy in use!")
        val alumno =  Alumno(
            alumno.id_alumno,
            alumno.no_control,
            alumno.correo,
            alumno.curp,
            alumno.nombre,
            LocalDate.parse(alumno.fecha_nacimiento),
            alumno.telefono?.replace("s/\\x00//g;", ""),
            alumno.sexo,
            alumno.fotografia?.replace("s/\\x00//g;", ""),
            alumno.contrasena,
            alumno.domicilio
        )
        print(alumno)
        return alumnoRepository!!.save(alumno)
    }

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

    @Throws(BusinessException::class)
    override fun updateAlumno(idAlumno: String, telefono: String?, domicilio: Domicilio?): Alumno {
        val optional: Optional<Alumno>
        try{
            optional = alumnoRepository!!.findById(UUID.fromString(idAlumno))
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el alumno con id ${idAlumno}!")

        optional.get().telefono = telefono
        optional.get().domicilio = domicilio

        try{
           alumnoRepository!!.save(optional.get())
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        return  optional.get()
    }

    @Throws(BusinessException::class)
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
                alumno.contrasena,
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