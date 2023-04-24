package com.github.andreldsr.cartinhas.players.domain.playerrole

import java.util.UUID

data class PlayerRole(
    val id: UUID? = null,
    val name: String,
    val image: String,
    val order: Int
)
