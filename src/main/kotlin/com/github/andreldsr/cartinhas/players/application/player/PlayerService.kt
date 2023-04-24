package com.github.andreldsr.cartinhas.players.application.player

import com.github.andreldsr.cartinhas.players.application.player.request.CreatePlayerRequest
import com.github.andreldsr.cartinhas.players.domain.player.Player
import java.util.UUID

interface PlayerService {
    fun create(request: CreatePlayerRequest): Player
    fun findById(id: UUID): Player
    fun findAll(): List<Player>
    fun update(id: UUID, player: Player): Player
    fun delete(id: UUID)
}
