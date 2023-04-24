package com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import java.util.UUID

interface NationalityDetailProjection {
    fun getId(): UUID
    fun getName(): String
    fun getFlag(): String
}

fun NationalityDetailProjection.toDomain() = Nationality(
    id = getId(),
    name = getName(),
    flag = getFlag()
)
