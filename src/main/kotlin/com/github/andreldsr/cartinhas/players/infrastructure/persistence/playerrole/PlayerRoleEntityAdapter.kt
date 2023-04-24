package com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole

import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole

fun PlayerRole.toEntity() = PlayerRoleEntity(id, name, image, order)

fun PlayerRoleEntity.toDomain() = PlayerRole(id, name, image, order)
