package com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.projection

import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.NationalityDetailProjection
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.toDomain
import java.util.UUID

interface PlayerDetailProjection {
    fun getId(): UUID
    fun getName(): String
    fun getNationality(): NationalityDetailProjection
}

fun PlayerDetailProjection.toDomain() = Player(
    id = getId(),
    name = getName(),
    nationality = getNationality().toDomain()
)
