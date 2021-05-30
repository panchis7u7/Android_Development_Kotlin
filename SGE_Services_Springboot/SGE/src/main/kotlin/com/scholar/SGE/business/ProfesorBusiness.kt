package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.dao.ProfesorRepository
import com.scholar.SGE.model.Alumno
import com.scholar.SGE.model.Profesor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class ProfesorBusiness: GraphQLQueryResolver, GraphQLMutationResolver, IProfesorBusiness {

    @Autowired
    val profesorRepository: ProfesorRepository? = null

    @Throws(BusinessException::class)
    override fun listProfesores(): List<Profesor> {
        try{
            return profesorRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadProfesor(idProfesor: Long): Profesor {
        val optional: Optional<Profesor>
        try{
            optional = profesorRepository!!.findById(idProfesor)
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el profesor con id $idProfesor!")

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveProfesor(profesor: Profesor): Profesor {
        try {
            return profesorRepository!!.save(profesor)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeProfesor(idProfesor: Long) {
        val optional: Optional<Profesor>
        try {
            optional = profesorRepository!!.findById(idProfesor)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el profesor con id $idProfesor!")
        else{
            try {
                profesorRepository!!.deleteById(idProfesor)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}