package com.scholar.SGE.business

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.model.Alumno
import com.scholar.SGE.dao.AlumnoRepository
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import java.util.Optional

@Service
class AlumnaBusiness: IAlumnoBusiness{

    @Autowired
    val alumnoRepository: AlumnoRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Alumno>{
        try{
            return alumnoRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idAlumno: Long): Alumno{
        val optional: Optional<Alumno>
        try{
            optional = alumnoRepository!!.findById(idAlumno)
        }catch(e: Exception){
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el alumno con id $idAlumno!")
        
        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun save(alumno: Alumno): Alumno{
        try{
            return alumnoRepository!!.save(alumno)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idAlumno: Long){
        val optional: Optional<Alumno>
        try{
            optional = alumnoRepository!!.findById(idAlumno)
        }catch(e: Exception){
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el alumno con id $idAlumno!")
        else{
            try {
            alumnoRepository.deleteById(idAlumno)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }

}