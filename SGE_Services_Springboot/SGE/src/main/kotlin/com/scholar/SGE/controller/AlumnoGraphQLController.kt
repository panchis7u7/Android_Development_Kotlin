package com.scholar.SGE.controller

import com.scholar.SGE.graphql.GraphQLProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController
@RequestMapping("graphql")
class AlumnoGraphQLController {

    @Autowired
    private val graphQLProvider: GraphQLProvider? = null

    @PostMapping("alumnos")
    fun list(@RequestBody query: String): ResponseEntity<*> {
        val executionResult = graphQLProvider!!.graphql().execute(query)
        return ResponseEntity(executionResult, HttpStatus.OK)
    }
}