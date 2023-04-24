package com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason

import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.toEntity
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.toEntity
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.toEntity
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.toDomain
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.toEntity

fun PlayerSeasonEntity.toDomain() = PlayerSeason(
    id,
    player.toDomain(),
    season.toDomain(),
    team.toDomain(),
    playerRole.toDomain(),
    image
)

fun PlayerSeason.toEntity() = PlayerSeasonEntity(
    id,
    player.toEntity(),
    season.toEntity(),
    team.toEntity(),
    playerRole.toEntity(),
    image
)
