package com.scholar.SGE.Controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("hola")
class User {

    @GetMapping("saludos")
    fun helloWord(): String = "Hola mundo a todos desde springboot!"
}