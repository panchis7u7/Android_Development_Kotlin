package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.business.ProfesorBusiness
import com.scholar.SGE.model.Profesor
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_PROFESORES)
class ProfesorController {
    
    @Autowired
    private val profesorBusiness: ProfesorBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Profesor>> {
        return try {
            ResponseEntity(profesorBusiness!!.listProfesores(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idProfesor: Long): ResponseEntity<Profesor> {
        return try {
            ResponseEntity(profesorBusiness!!.loadProfesor(idProfesor), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody Profesor: Profesor): ResponseEntity<Any> {
        return try {
            profesorBusiness!!.saveProfesor(Profesor)
            val response = HttpHeaders()
            response.set("location", Constants.URL_PROFESORES + "/" + Profesor.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody Profesor: Profesor): ResponseEntity<Any> {
        return try {
            profesorBusiness!!.saveProfesor(Profesor)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idProfesor: Long): ResponseEntity<Any> {
        return try {
            profesorBusiness!!.removeProfesor(idProfesor)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    
}