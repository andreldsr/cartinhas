package com.github.andreldsr.cartinhas.players.application.playerrole.impl

import com.github.andreldsr.cartinhas.players.application.playerrole.PlayerRoleService
import com.github.andreldsr.cartinhas.players.application.playerrole.request.CreatePlayerRoleRequest
import com.github.andreldsr.cartinhas.players.application.playerrole.request.toDomain
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRoleRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlayerRoleServiceImpl(private val repository: PlayerRoleRepository) : PlayerRoleService {
    override fun findById(id: UUID) = repository.findById(id)

    override fun findAll() = repository.findAll()

    override fun save(request: CreatePlayerRoleRequest) = repository.save(request.toDomain())

    override fun delete(id: UUID) = repository.delete(id)

    override fun update(id: UUID, playerRole: PlayerRole): PlayerRole = repository.update(id, playerRole)
}
