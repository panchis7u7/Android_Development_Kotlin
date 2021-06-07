package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.dao.AsignaturaRepository
import com.scholar.SGE.model.Asignatura
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AsignaturaBusiness: GraphQLQueryResolver, IAsignaturaBusiness {
    companion object {
        //private var factory: SessionFactory? = null
    }
    @Autowired
    val asignaturaRepository: AsignaturaRepository? = null

    /*init {
        try {
            //factory = Configuration().configure().buildSessionFactory()
        } catch (e: ExceptionInInitializerError) {
            throw ExceptionInInitializerError(e.message)
            print("Failed to create a sessionFactory Object: ${e.message}")
        }
    }*/

    @Throws(BusinessException::class)
    override fun listAsignaturas(): List<Asignatura>{
        try{
            return asignaturaRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadAsignatura(clave: String): Asignatura {
        val optional: Optional<Asignatura>
        try{
            optional = asignaturaRepository!!.findByCLave(clave)
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Asignatura con la clave $clave!")

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveAsignatura(Asignatura: Asignatura): Asignatura {
        //var session = factory?.openSession()
        //var tx: Transaction? = null

        try {
            //tx = session?.beginTransaction()
            return asignaturaRepository!!.save(Asignatura)
            //tx?.commit()
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeAsignatura(idAsignatura: Long){
        val optional: Optional<Asignatura>
        try {
            optional = asignaturaRepository!!.findById(idAsignatura)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro la Asignatura con id $idAsignatura!")
        else{
            try {
                asignaturaRepository!!.deleteById(idAsignatura)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}