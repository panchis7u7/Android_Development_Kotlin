package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.dao.DomicilioRepository
import com.scholar.SGE.model.Domicilio
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Service
class DomicilioBusiness: GraphQLQueryResolver, IDomicilioBusiness {
    companion object {
        //private var factory: SessionFactory? = null
    }
    @Autowired
    val domicilioRepository: DomicilioRepository? = null

    /*init {
        try {
            //factory = Configuration().configure().buildSessionFactory()
        } catch (e: ExceptionInInitializerError) {
            throw ExceptionInInitializerError(e.message)
            print("Failed to create a sessionFactory Object: ${e.message}")
        }
    }*/

    @Throws(BusinessException::class)
    override fun listDomicilios(): List<Domicilio>{
        try{
            return domicilioRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadDomicilio(idDomicilio: Long): Domicilio {
        val optional: Optional<Domicilio>
        try{
            optional = domicilioRepository!!.findById(idDomicilio)
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Domicilio con id $idDomicilio!")

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveDomicilio(Domicilio: Domicilio): Domicilio {
        //val session = factory?.openSession()
        //var tx: Transaction? = null

        try {
            //tx = session?.beginTransaction()
            return domicilioRepository!!.save(Domicilio)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeDomicilio(idDomicilio: Long){
        val optional: Optional<Domicilio>
        try {
            optional = domicilioRepository!!.findById(idDomicilio)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Domicilio con id $idDomicilio!")
        else{
            try {
                domicilioRepository!!.deleteById(idDomicilio)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}