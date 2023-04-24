package com.github.andreldsr.cartinhas.players.domain.team

import java.util.UUID

class TeamFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = Team(
            name = "",
            image = "",
            background = ""
        )
    }
}
