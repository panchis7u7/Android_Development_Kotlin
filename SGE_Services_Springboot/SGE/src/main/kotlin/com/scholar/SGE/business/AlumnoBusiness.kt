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
import com.scholar.SGE.model.Residencia
import com.scholar.SGE.util.Constants
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.postgresql.shaded.com.ongres.scram.common.util.CryptoUtil
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDate
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashMap

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

    @Throws(NotFoundException::class, AuthException::class)
    override fun validateUser(email: String, password: String): Alumno {
        val optional: Optional<Alumno>
        try{
            optional = alumnoRepository!!.findByEmail(email.trim())
            if(!optional.isPresent)
                throw NotFoundException("No se encontro el alumno con el correo: $email!")
            val alumno = optional.get()
            println(alumno.contrasena.trim())
            if(!BCryptPasswordEncoder().matches(password, alumno.contrasena.trim()))
                throw AuthException("Usuario o contraseña incorrecto!")
            return alumno
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }
    }

    override fun registerUser(alumno: AlumnoGraphQL): Alumno {
        val pattern = Pattern.compile("^(.+)@(.+)$")
        alumno.contrasena = BCryptPasswordEncoder().encode(alumno.contrasena)
        if (!pattern.matcher(alumno.correo).matches())
            throw AuthException("Formato de correo invalido!")
        val count = alumnoRepository!!.getCountByAlumnoCorreo(alumno.correo)
        if (count > 0)
            throw AuthException("Account alredy in use!")
        val al = Alumno(
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
            alumno.residencia,
            alumno.gruposAlumnos
        )
        return alumnoRepository!!.save(al)
    }

     override fun generateJWTToken(alumno: Alumno): Map<String, String> {
        var timeStamp = System.currentTimeMillis()
        val token = Jwts.builder().signWith(SignatureAlgorithm.HS512, Constants.API_SECRET_KEY)
            .setIssuedAt(Date(timeStamp))
            .setExpiration(Date(timeStamp + Constants.TOKEN_VALIDITY))
            .claim("idAlumno", alumno.id)
            .claim("correo", alumno.correo)
            .claim("nombre", alumno.nombre)
            .claim("noControl", alumno.no_control)
            .compact()
        val map = HashMap<String, String>()
        map.put("token", token)
        return map
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

    @Throws(BusinessException::class, AuthException::class)
    override fun saveAlumno(alumno: Alumno): Alumno{
        //var session = factory?.openSession()
        //var tx: Transaction? = null

        try {
            //tx = session?.beginTransaction()
            val pattern = Pattern.compile("^(.+)@(.+)$")
            alumno.contrasena = BCryptPasswordEncoder().encode(alumno.contrasena)
            if (!pattern.matcher(alumno.correo).matches())
                throw AuthException("Formato de correo invalido!")
            val count = alumnoRepository!!.getCountByAlumnoCorreo(alumno.correo)
            if (count > 0)
                throw AuthException("Account alredy in use!")
            return alumnoRepository!!.save(alumno)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun updateAlumno(idAlumno: String, telefono: String?, residencia: Residencia?): Alumno {
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
        optional.get().residencia = residencia

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
                alumno.residencia,
                alumno.gruposAlumnos
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

    @Throws(BusinessException::class, NotFoundException::class)
    override fun getResidencia(idAlumno: String): Residencia {
        val optional: Optional<Alumno>
        try{
            optional =  alumnoRepository!!.findById(UUID.fromString(idAlumno))

            if (!optional.isPresent)
                throw NotFoundException("No se encontro el alumno con id $idAlumno!")

            return optional.get().residencia!!
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }
}