package com.github.andreldsr.cartinhas.players.domain.player

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import java.util.UUID

data class Player(
    val id: UUID? = null,
    val name: String,
    val nationality: Nationality
)
