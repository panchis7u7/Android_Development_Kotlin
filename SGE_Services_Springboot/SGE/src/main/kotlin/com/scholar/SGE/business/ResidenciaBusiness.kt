package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.dao.ColoniaRepository
import com.scholar.SGE.dao.EstadoRepository
import com.scholar.SGE.dao.MunicipioRepository
import com.scholar.SGE.dao.ResidenciaRepository
import com.scholar.SGE.model.Colonia
import com.scholar.SGE.model.Estado
import com.scholar.SGE.model.Municipio
import com.scholar.SGE.model.Residencia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ResidenciaBusiness: GraphQLQueryResolver, IResidenciaBusiness {
    companion object {
        //private var factory: SessionFactory? = null
    }
    @Autowired
    val residenciaRepository: ResidenciaRepository? = null
    @Autowired
    val coloniaRepository: ColoniaRepository? = null
    @Autowired
    val municipioRepository: MunicipioRepository? = null
    @Autowired
    val estadoRepository: EstadoRepository? = null

    /*init {
        try {
            //factory = Configuration().configure().buildSessionFactory()
        } catch (e: ExceptionInInitializerError) {
            throw ExceptionInInitializerError(e.message)
            print("Failed to create a sessionFactory Object: ${e.message}")
        }
    }*/

    @Throws(BusinessException::class)
    override fun listResidencias(): List<Residencia>{
        try{
            return residenciaRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadResidencia(idResidencia: Long): Residencia {
        val optional: Optional<Residencia>
        try{
            optional = residenciaRepository!!.findById(idResidencia)
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro la Residencia con id $idResidencia!")

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveResidencia(Residencia: Residencia): Residencia {
        //val session = factory?.openSession()
        //var tx: Transaction? = null

        try {
            //tx = session?.beginTransaction()
            return residenciaRepository!!.save(Residencia)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeResidencia(idResidencia: Long){
        val optional: Optional<Residencia>
        try {
            optional = residenciaRepository!!.findById(idResidencia)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Residencia con id $idResidencia!")
        else{
            try {
                residenciaRepository!!.deleteById(idResidencia)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }

    override fun listColonias(): List<Colonia> {
        try{
            return coloniaRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    override fun listMunicipios(): List<Municipio> {
        try{
            return municipioRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    override fun listEstados(): List<Estado> {
        try{
            return estadoRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }
}