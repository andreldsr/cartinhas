package com.github.andreldsr.cartinhas.players.domain.team

import com.github.andreldsr.cartinhas.players.domain.player.Player
import java.util.UUID

data class Team(
    val id: UUID? = null,
    val name: String,
    val image: String,
    val background: String,
    val players: List<Player> = emptyList()
)
