package com.github.andreldsr.cartinhas.players.application.nationality.request

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality

data class CreateNationalityRequest(
    val name: String,
    val flag: String
)

fun CreateNationalityRequest.toDomain() = Nationality(
    name = name,
    flag = flag
)
