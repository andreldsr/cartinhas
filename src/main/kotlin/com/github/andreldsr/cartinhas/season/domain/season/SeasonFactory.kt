package com.github.andreldsr.cartinhas.season.domain.season

import java.util.UUID

class SeasonFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)

        fun empty() = Season(name = "")
    }
}
