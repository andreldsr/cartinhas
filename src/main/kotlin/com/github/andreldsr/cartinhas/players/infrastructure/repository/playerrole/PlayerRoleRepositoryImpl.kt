package com.github.andreldsr.cartinhas.players.infrastructure.repository.playerrole

import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRoleRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.PlayerRoleJpaRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class PlayerRoleRepositoryImpl(
    private val playerRoleJpaRepository: PlayerRoleJpaRepository
) : PlayerRoleRepository {
    override fun save(playerRole: PlayerRole): PlayerRole {
        return playerRoleJpaRepository
            .save(playerRole.toEntity())
            .toDomain()
    }

    override fun findById(id: UUID): PlayerRole {
        return playerRoleJpaRepository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("PlayerRole not found") }
    }

    override fun findAll(): List<PlayerRole> {
        return playerRoleJpaRepository
            .findAll()
            .map { it.toDomain() }
    }

    override fun delete(id: UUID) {
        playerRoleJpaRepository.deleteById(id)
    }

    override fun update(id: UUID, playerRole: PlayerRole): PlayerRole {
        return playerRoleJpaRepository
            .findById(id)
            .map { playerRole.toEntity() }
            .map { playerRoleJpaRepository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("PlayerRole not found") }
    }

    override fun exists(id: UUID): Boolean {
        return playerRoleJpaRepository.existsById(id)
    }
}
