package com.github.andreldsr.cartinhas.season.domain.playerseason

import com.github.andreldsr.cartinhas.players.domain.player.PlayerFactory
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRoleFactory
import com.github.andreldsr.cartinhas.players.domain.team.TeamFactory
import com.github.andreldsr.cartinhas.season.domain.season.SeasonFactory
import java.util.UUID

class PlayerSeasonFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = PlayerSeason(
            player = PlayerFactory.empty(),
            season = SeasonFactory.empty(),
            team = TeamFactory.empty(),
            playerRole = PlayerRoleFactory.empty(),
            image = ""

        )
    }
}
