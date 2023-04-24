package com.github.andreldsr.cartinhas.players.domain.player

import com.github.andreldsr.cartinhas.players.domain.nationality.NationalityFactory
import java.util.UUID

class PlayerFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = Player(
            name = "",
            nationality = NationalityFactory.empty()
        )
    }
}
