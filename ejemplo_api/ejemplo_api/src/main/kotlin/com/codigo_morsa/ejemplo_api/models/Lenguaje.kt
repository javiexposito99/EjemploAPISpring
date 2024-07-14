package com.codigo_morsa.ejemplo_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Date
import java.util.*


@Entity
@Table(name = "lenguaje")
data class Lenguaje(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int?, //El signo de interrogación identifica de que el valor puede ser null.

        val nombre: String,
        val lazamiento: Date, //Date
        val tipado_fuerte: Boolean

)
