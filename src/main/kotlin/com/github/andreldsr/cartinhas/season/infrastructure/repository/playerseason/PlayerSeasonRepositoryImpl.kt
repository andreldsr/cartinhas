package com.github.andreldsr.cartinhas.season.infrastructure.repository.playerseason

import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeasonRepository
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.PlayerSeasonJpaRepository
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.toDomain
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class PlayerSeasonRepositoryImpl(
    private val playerSeasonJpaRepository: PlayerSeasonJpaRepository
) : PlayerSeasonRepository {
    override fun save(playerSeason: PlayerSeason) = playerSeasonJpaRepository
        .save(playerSeason.toEntity())
        .toDomain()

    override fun findById(id: UUID): PlayerSeason = playerSeasonJpaRepository
        .findById(id)
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("PlayerSeason not found") }

    override fun findAll() = playerSeasonJpaRepository
        .findAll()
        .map { it.toDomain() }

    override fun delete(id: UUID) = playerSeasonJpaRepository.deleteById(id)

    override fun update(id: UUID, playerSeason: PlayerSeason): PlayerSeason = playerSeasonJpaRepository
        .findById(id)
        .map { playerSeason.toEntity() }
        .map { playerSeasonJpaRepository.save(it) }
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("PlayerSeason not found") }

    override fun exists(id: UUID) = playerSeasonJpaRepository.existsById(id)
}
