package com.github.andreldsr.cartinhas.players.infrastructure.repository.player

import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.players.domain.player.PlayerRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.PlayerJpaRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class PlayerRepositoryImpl(private val repository: PlayerJpaRepository) : PlayerRepository {
    override fun findAll(): List<Player> {
        return repository
            .findAll()
            .map { it.toDomain() }
    }

    override fun findById(id: UUID): Player {
        return repository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Player not found") }
    }

    override fun save(player: Player): Player {
        return repository
            .save(player.toEntity())
            .toDomain()
    }

    override fun update(id: UUID, player: Player): Player {
        return repository
            .findById(id)
            .map { player.toEntity() }
            .map { repository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Player not found") }
    }

    override fun delete(player: Player) {
        repository.delete(player.toEntity())
    }

    override fun deleteById(id: UUID) {
        repository.deleteById(id)
    }

    override fun exists(id: UUID): Boolean {
        return repository.existsById(id)
    }
}
