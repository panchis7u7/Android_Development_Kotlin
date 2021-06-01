package com.scholar.SGE.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import com.scholar.SGE.util.Constants
import com.scholar.SGE.business.IAlumnoBusiness
import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.model.Alumno

@RestController
@RequestMapping(Constants.URL_ALUMNOS)
class AlumnoController {

    @Autowired
    val alumnoBusiness: IAlumnoBusiness? = null

    @PostMapping("/login")
    fun loginAlumno(@RequestBody user: Map<String, String>): ResponseEntity<Map<String, String>> {
        return try {
            val usuario = alumnoBusiness!!.validateUser(user.get("correo") as String, user.get("contrasena") as String)
            return ResponseEntity(alumnoBusiness!!.generateJWTToken(usuario), HttpStatus.CREATED)
        } catch(e: BusinessException) {
            val response: HashMap<String, String> = hashMapOf()
            response.put("status", e.message!!)
            return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            val response: HashMap<String, String> = hashMapOf()
            response.put("status", e.message!!)
            return ResponseEntity(response, HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/register")
    fun registerAlumno(@RequestBody alumno: Alumno): ResponseEntity<Any> {
        return try {
            alumnoBusiness!!.saveAlumno(alumno)
            ResponseEntity(alumnoBusiness!!.generateJWTToken(alumno), HttpStatus.CREATED)
        } catch(e: BusinessException) {
            val response: HashMap<String, String> = hashMapOf()
            response.put("status", e.message!!)
            return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("")
    fun list(): ResponseEntity<List<Alumno>> {
        return try {
            ResponseEntity(alumnoBusiness!!.listAlumnos(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idAlumno: String): ResponseEntity<Alumno> {
        return try {
            ResponseEntity(alumnoBusiness!!.loadAlumno(idAlumno), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody alumno: Alumno): ResponseEntity<Any> {
        return try {
            alumnoBusiness!!.saveAlumno(alumno)
            val response = HttpHeaders()
            response.set("location", Constants.URL_ALUMNOS + "/" + alumno.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody alumno: Alumno): ResponseEntity<Any> {
        return try {
            alumnoBusiness!!.saveAlumno(alumno)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idAlumno: String): ResponseEntity<Any> {
        return try {
            alumnoBusiness!!.removeAlumno(idAlumno)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}