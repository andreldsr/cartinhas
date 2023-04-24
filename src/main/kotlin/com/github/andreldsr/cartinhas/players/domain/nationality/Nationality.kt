package com.github.andreldsr.cartinhas.players.domain.nationality

import java.util.UUID

data class Nationality(
    val id: UUID? = null,
    val name: String,
    val flag: String
)
