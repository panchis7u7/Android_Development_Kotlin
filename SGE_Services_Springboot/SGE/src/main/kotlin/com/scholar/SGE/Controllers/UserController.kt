package com.scholar.SGE.Controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hola")
class User {

    @GetMapping("saludos")
    fun helloWord(): String = "Hola mundo a todos desde springboot!"
}