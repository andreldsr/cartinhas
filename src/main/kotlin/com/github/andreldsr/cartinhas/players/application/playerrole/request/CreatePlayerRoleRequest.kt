package com.github.andreldsr.cartinhas.players.application.playerrole.request

import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole

data class CreatePlayerRoleRequest(
    val name: String,
    val image: String,
    val order: Int
)

fun CreatePlayerRoleRequest.toDomain() = PlayerRole(
    name = name,
    image = image,
    order = order
)
