package com.codigo_morsa.ejemplo_api.controllers

import com.codigo_morsa.ejemplo_api.models.Lenguaje
import com.codigo_morsa.ejemplo_api.services.LenguajeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController //Con esto identificamos al framework que va contar con rutas que tiene que tratarlas como HTTP.
class Controllers {

    lateinit var lenguajeService: LenguajeService

    @Autowired
    constructor(lenguajeService: LenguajeService){
        this.lenguajeService = lenguajeService
    }

    @GetMapping("/")
    fun holaMundo(): String {
        return "Hola Mundo";
    }

    @GetMapping("/lenguaje")
    fun leerLenguajes(): List<Lenguaje>{
        return lenguajeService.getAllLenguajes()

    }

    @PostMapping("/lenguaje")
    fun crearLenguaje(
          @RequestBody nuevoLenguaje: Lenguaje
    ): ResponseEntity<String> {
        return lenguajeService.crearLenguaje(nuevoLenguaje)
    }

}