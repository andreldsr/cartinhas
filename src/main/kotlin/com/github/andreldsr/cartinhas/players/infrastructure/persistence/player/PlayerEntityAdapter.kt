package com.github.andreldsr.cartinhas.players.infrastructure.persistence.player

import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.toEntity

fun PlayerEntity.toDomain() = Player(id, name, nationality!!.toDomain())
fun Player.toEntity() = PlayerEntity(id, name, nationality.toEntity())
