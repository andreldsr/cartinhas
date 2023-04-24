package com.github.andreldsr.cartinhas.card.domain.card

import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import java.util.UUID

data class Card(
    val id: UUID? = null,
    val playerSeason: PlayerSeason,
    val image: String,
    val lastScore: Int,
    val lastDiff: Int,
    val highestScore: Int,
    val bagres: Int,
    val craques: Int
)
