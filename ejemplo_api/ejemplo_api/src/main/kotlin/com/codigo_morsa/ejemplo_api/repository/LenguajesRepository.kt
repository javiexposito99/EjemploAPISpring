package com.codigo_morsa.ejemplo_api.repository

import com.codigo_morsa.ejemplo_api.models.Lenguaje
import org.springframework.data.repository.CrudRepository

interface LenguajesRepository: CrudRepository<Lenguaje, Int> {

}