package com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.projection

import com.github.andreldsr.cartinhas.players.domain.team.Team
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.projection.toDomain
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.projection.PlayerSeasonListProjection
import java.util.UUID

interface TeamDetailsProjection {
    fun getId(): UUID
    fun getName(): String
    fun getImage(): String
    fun getBackground(): String
    fun getPlayers(): List<PlayerSeasonListProjection>
}

fun TeamDetailsProjection.toDomain() = Team(
    id = getId(),
    name = getName(),
    image = getImage(),
    background = getBackground(),
    players = getPlayers().map { it.getPlayer().toDomain() }
)
