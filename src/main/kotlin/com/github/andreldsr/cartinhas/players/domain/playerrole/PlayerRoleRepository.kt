package com.github.andreldsr.cartinhas.players.domain.playerrole

import java.util.UUID

interface PlayerRoleRepository {
    fun save(playerRole: PlayerRole): PlayerRole
    fun findById(id: UUID): PlayerRole
    fun findAll(): List<PlayerRole>
    fun delete(id: UUID)
    fun update(id: UUID, playerRole: PlayerRole): PlayerRole
    fun exists(id: UUID): Boolean
}
