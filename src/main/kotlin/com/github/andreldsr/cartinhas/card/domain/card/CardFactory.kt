package com.github.andreldsr.cartinhas.card.domain.card

import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeasonFactory
import java.util.UUID

class CardFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = Card(
            playerSeason = PlayerSeasonFactory.empty(),
            image = "",
            lastScore = 0,
            lastDiff = 0,
            highestScore = 0,
            craques = 0,
            bagres = 0
        )
    }
}
