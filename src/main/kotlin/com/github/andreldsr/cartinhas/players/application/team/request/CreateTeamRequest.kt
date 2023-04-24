package com.github.andreldsr.cartinhas.players.application.team.request

import com.github.andreldsr.cartinhas.players.domain.team.Team

data class CreateTeamRequest(
    val name: String,
    val image: String,
    val background: String
)

fun CreateTeamRequest.toDomain() = Team(
    name = name,
    image = image,
    background = background
)
