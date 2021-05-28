package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.business.IAsignaturaBusiness
import com.scholar.SGE.model.Asignatura
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_ASIGNATURAS)
class AsignaturaController {
    @Autowired
    val asignaturaBusiness: IAsignaturaBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Asignatura>> {
        return try {
            ResponseEntity(asignaturaBusiness!!.listAsignaturas(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idAsignatura: Long): ResponseEntity<Asignatura> {
        return try {
            ResponseEntity(asignaturaBusiness!!.loadAsignatura(idAsignatura), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody Asignatura: Asignatura): ResponseEntity<Any> {
        return try {
            asignaturaBusiness!!.saveAsignatura(Asignatura)
            val response = HttpHeaders()
            response.set("location", Constants.URL_ASIGNATURAS + "/" + Asignatura.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody Asignatura: Asignatura): ResponseEntity<Any> {
        return try {
            asignaturaBusiness!!.saveAsignatura(Asignatura)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idAsignatura: Long): ResponseEntity<Any> {
        return try {
            asignaturaBusiness!!.removeAsignatura(idAsignatura)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}