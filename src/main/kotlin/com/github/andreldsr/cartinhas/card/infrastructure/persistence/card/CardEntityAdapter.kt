package com.github.andreldsr.cartinhas.card.infrastructure.persistence.card

import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.toDomain
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.toEntity

fun CardEntity.toDomain() = Card(
    id,
    playerSeason.toDomain(),
    image,
    lastScore,
    lastDiff,
    highestScore,
    bagres,
    craques
)

fun Card.toEntity() = CardEntity(
    id,
    playerSeason.toEntity(),
    image,
    lastScore,
    lastDiff,
    highestScore,
    bagres,
    craques
)
