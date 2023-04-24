package com.github.andreldsr.cartinhas.players.domain.player

import java.util.UUID

interface PlayerRepository {
    fun findAll(): List<Player>
    fun findById(id: UUID): Player
    fun save(player: Player): Player
    fun update(id: UUID, player: Player): Player
    fun delete(player: Player)
    fun deleteById(id: UUID)
    fun exists(id: UUID): Boolean
}
