package com.github.andreldsr.cartinhas.players.domain.nationality

import java.util.UUID

class NationalityFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = Nationality(
            name = "",
            flag = ""
        )
    }
}
