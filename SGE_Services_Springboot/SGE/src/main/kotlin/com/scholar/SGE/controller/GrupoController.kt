package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.business.IGrupoBusiness
import com.scholar.SGE.model.Grupo
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_GRUPOS)
class GrupoController {
    
    @Autowired
    val grupoBusiness: IGrupoBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Grupo>> {
        return try {
            ResponseEntity(grupoBusiness!!.listGrupos(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idGrupo: Long): ResponseEntity<Grupo> {
        return try {
            ResponseEntity(grupoBusiness!!.loadGrupo(idGrupo), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody Grupo: Grupo): ResponseEntity<Any> {
        return try {
            grupoBusiness!!.saveGrupo(Grupo)
            val response = HttpHeaders()
            response.set("location", Constants.URL_GRUPOS + "/" + Grupo.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody Grupo: Grupo): ResponseEntity<Any> {
        return try {
            grupoBusiness!!.saveGrupo(Grupo)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idGrupo: Long): ResponseEntity<Any> {
        return try {
            grupoBusiness!!.removeGrupo(idGrupo)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}