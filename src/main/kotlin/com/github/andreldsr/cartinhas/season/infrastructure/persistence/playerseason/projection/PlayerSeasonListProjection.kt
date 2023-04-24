package com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.projection

import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.projection.PlayerDetailProjection

interface PlayerSeasonListProjection {
    fun getPlayer(): PlayerDetailProjection
    fun getImage(): String
}
