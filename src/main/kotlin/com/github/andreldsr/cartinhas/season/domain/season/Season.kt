package com.github.andreldsr.cartinhas.season.domain.season

import java.util.UUID

data class Season(
    val id: UUID? = null,
    val name: String,
    val current: Boolean = false
)
