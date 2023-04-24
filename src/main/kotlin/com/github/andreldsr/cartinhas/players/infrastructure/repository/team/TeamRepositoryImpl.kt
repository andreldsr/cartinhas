package com.github.andreldsr.cartinhas.players.infrastructure.repository.team

import com.github.andreldsr.cartinhas.players.domain.team.Team
import com.github.andreldsr.cartinhas.players.domain.team.TeamRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.TeamJpaRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.projection.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class TeamRepositoryImpl(
    private val teamRepository: TeamJpaRepository
) : TeamRepository {
    override fun save(team: Team) = teamRepository
        .save(team.toEntity())
        .toDomain()

    override fun findById(id: UUID): Team = teamRepository
        .findDetailById(id)
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("Team not found") }

    override fun findAll() = teamRepository.findAll().map { it.toDomain() }

    override fun delete(id: UUID) = teamRepository.deleteById(id)

    override fun update(id: UUID, team: Team): Team = teamRepository
        .findById(id)
        .map { team.toEntity() }
        .map { teamRepository.save(it) }
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("Team not found") }

    override fun exists(id: UUID) = teamRepository.existsById(id)
}
