package com.github.andreldsr.cartinhas.card.application.card.request

import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeasonFactory
import java.util.UUID

data class CreateCardRequest(
    val playerSeasonId: UUID,
    val image: String
)

fun CreateCardRequest.toDomain() = Card(
    playerSeason = PlayerSeasonFactory.reference(playerSeasonId),
    image = image,
    lastScore = 0,
    highestScore = 0,
    bagres = 0,
    craques = 0,
    lastDiff = 0
)
