package com.github.andreldsr.cartinhas.players.domain.playerrole

import java.util.UUID

class PlayerRoleFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = PlayerRole(
            name = "",
            image = "",
            order = 0
        )
    }
}
