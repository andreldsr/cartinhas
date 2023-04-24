package com.github.andreldsr.cartinhas.season.application.season.request

import com.github.andreldsr.cartinhas.season.domain.season.Season

data class CreateSeasonRequest(
    val name: String
)

fun CreateSeasonRequest.toDomain() = Season(name = name)
