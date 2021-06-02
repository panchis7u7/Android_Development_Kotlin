package com.scholar.SGE.controller

import com.scholar.SGE.Exception.BusinessException
import com.scholar.SGE.Exception.NotFoundException
import com.scholar.SGE.business.IResidenciaBusiness
import com.scholar.SGE.model.Colonia
import com.scholar.SGE.model.Estado
import com.scholar.SGE.model.Municipio
import com.scholar.SGE.model.Residencia
import com.scholar.SGE.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_DOMICILIOS)
class ResidenciaController {
    @Autowired
    val residenciaBusiness: IResidenciaBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Residencia>> {
        return try {
            ResponseEntity(residenciaBusiness!!.listResidencias(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/colonias")
    fun listColonia(): ResponseEntity<List<Colonia>> {
        return try {
            ResponseEntity(residenciaBusiness!!.listColonias(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/municipios")
    fun listMunicipios(): ResponseEntity<List<Municipio>> {
        return try {
            ResponseEntity(residenciaBusiness!!.listMunicipios(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/estados")
    fun listEstados(): ResponseEntity<List<Estado>> {
        return try {
            ResponseEntity(residenciaBusiness!!.listEstados(), HttpStatus.OK)
        } catch(e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idResidencia: Long): ResponseEntity<Residencia> {
        return try {
            ResponseEntity(residenciaBusiness!!.loadResidencia(idResidencia), HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody Residencia: Residencia): ResponseEntity<Any> {
        return try {
            residenciaBusiness!!.saveResidencia(Residencia)
            val response = HttpHeaders()
            response.set("location", Constants.URL_DOMICILIOS + "/" + Residencia.id)
            ResponseEntity(response, HttpStatus.CREATED)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody Residencia: Residencia): ResponseEntity<Any> {
        return try {
            residenciaBusiness!!.saveResidencia(Residencia)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idResidencia: Long): ResponseEntity<Any> {
        return try {
            residenciaBusiness!!.removeResidencia(idResidencia)
            ResponseEntity(HttpStatus.OK)
        } catch(e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch(e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}