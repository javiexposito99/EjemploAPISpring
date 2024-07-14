package com.codigo_morsa.ejemplo_api.services

import com.codigo_morsa.ejemplo_api.models.Lenguaje
import com.codigo_morsa.ejemplo_api.repository.LenguajesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody


@Service
class LenguajeService {

    lateinit var lenguajesRepository: LenguajesRepository

    @Autowired
    constructor(lenguajesRepository: LenguajesRepository) {
        this.lenguajesRepository = lenguajesRepository
    }

    fun getAllLenguajes(): List<Lenguaje> {
        return lenguajesRepository.findAll().toList()
    }

    fun crearLenguaje(@Validated @RequestBody nuevoLenguaje: Lenguaje): ResponseEntity<String> {
        return lenguajesRepository.save(nuevoLenguaje).let {
            ResponseEntity ("Nuevo lenguaje creado! ID: ${it.id}", HttpStatus.CREATED)
        }
    }

}