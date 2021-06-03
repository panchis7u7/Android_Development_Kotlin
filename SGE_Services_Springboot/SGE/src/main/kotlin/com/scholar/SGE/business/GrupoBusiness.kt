package com.scholar.SGE.business

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.dao.GrupoRepository
import com.scholar.SGE.model.Grupo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class GrupoBusiness: GraphQLQueryResolver, IGrupoBusiness {

    @Autowired
    val grupoRepository: GrupoRepository? = null

    @Throws(BusinessException::class)
    override fun listGrupos(): List<Grupo> {
        try{
            return grupoRepository!!.findAll()
        }catch(e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun loadGrupo(idGrupo: Long): Grupo {
        val optional: Optional<Grupo>
        try{
            optional = grupoRepository!!.findById(idGrupo)
        } catch(e: Exception){
            throw BusinessException(e.message)
        } catch (e2: IllegalArgumentException){
            throw IllegalArgumentException(e2.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Grupo con id $idGrupo!")

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun saveGrupo(Grupo: Grupo): Grupo {
        try {
            return grupoRepository!!.save(Grupo)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun removeGrupo(idGrupo: Long) {
        val optional: Optional<Grupo>
        try {
            optional = grupoRepository!!.findById(idGrupo)
        } catch(e: Exception) {
            throw BusinessException(e.message)
        }

        if(!optional.isPresent)
            throw NotFoundException("No se encontro el Grupo con id $idGrupo!")
        else{
            try {
                grupoRepository!!.deleteById(idGrupo)
            } catch(e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}