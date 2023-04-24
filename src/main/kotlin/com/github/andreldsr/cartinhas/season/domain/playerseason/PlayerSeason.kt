package com.github.andreldsr.cartinhas.season.domain.playerseason

import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import com.github.andreldsr.cartinhas.players.domain.team.Team
import com.github.andreldsr.cartinhas.season.domain.season.Season
import java.util.UUID

data class PlayerSeason(
    val id: UUID? = null,
    val player: Player,
    val season: Season,
    val team: Team,
    val playerRole: PlayerRole,
    val image: String
)
