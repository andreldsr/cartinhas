package com.github.andreldsr.cartinhas.players.application.playerrole

import com.github.andreldsr.cartinhas.players.application.playerrole.request.CreatePlayerRoleRequest
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import java.util.UUID

interface PlayerRoleService {
    fun findById(id: UUID): PlayerRole
    fun findAll(): List<PlayerRole>
    fun save(request: CreatePlayerRoleRequest): PlayerRole
    fun delete(id: UUID)
    fun update(id: UUID, playerRole: PlayerRole): PlayerRole
}
