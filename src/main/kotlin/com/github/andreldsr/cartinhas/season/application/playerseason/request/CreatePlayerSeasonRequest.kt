package com.github.andreldsr.cartinhas.season.application.playerseason.request

import com.github.andreldsr.cartinhas.players.domain.player.PlayerFactory
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRoleFactory
import com.github.andreldsr.cartinhas.players.domain.team.TeamFactory
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import com.github.andreldsr.cartinhas.season.domain.season.SeasonFactory
import java.util.UUID

data class CreatePlayerSeasonRequest(
    val playerId: UUID,
    val seasonId: UUID,
    val teamId: UUID,
    val playerRoleId: UUID,
    val image: String
)

fun CreatePlayerSeasonRequest.toDomain() = PlayerSeason(
    player = PlayerFactory.reference(playerId),
    season = SeasonFactory.reference(seasonId),
    team = TeamFactory.reference(teamId),
    playerRole = PlayerRoleFactory.reference(playerRoleId),
    image = image
)
