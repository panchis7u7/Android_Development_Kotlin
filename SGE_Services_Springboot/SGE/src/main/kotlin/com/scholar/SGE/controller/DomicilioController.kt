package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.business.IDomicilioBusiness
import com.scholar.SGE.model.Domicilio
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_DOMICILIOS)
class DomicilioController {
    @Autowired
    val domicilioBusiness: IDomicilioBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Domicilio>> {
        return try {
            ResponseEntity(domicilioBusiness!!.listDomicilios(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idDomicilio: Long): ResponseEntity<Domicilio> {
        return try {
            ResponseEntity(domicilioBusiness!!.loadDomicilio(idDomicilio), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody Domicilio: Domicilio): ResponseEntity<Any> {
        return try {
            domicilioBusiness!!.saveDomicilio(Domicilio)
            val response = HttpHeaders()
            response.set("location", Constants.URL_DOMICILIOS + "/" + Domicilio.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody Domicilio: Domicilio): ResponseEntity<Any> {
        return try {
            domicilioBusiness!!.saveDomicilio(Domicilio)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idDomicilio: Long): ResponseEntity<Any> {
        return try {
            domicilioBusiness!!.removeDomicilio(idDomicilio)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}