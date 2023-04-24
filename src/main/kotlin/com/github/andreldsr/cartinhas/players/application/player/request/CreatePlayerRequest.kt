package com.github.andreldsr.cartinhas.players.application.player.request

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import com.github.andreldsr.cartinhas.players.domain.player.Player
import java.util.UUID

data class CreatePlayerRequest(
    val name: String,
    val nationalityId: UUID
)

fun CreatePlayerRequest.toDomain() = Player(
    name = name,
    nationality = Nationality(nationalityId, "", "")
)
