package com.github.andreldsr.cartinhas.season.application.playerseason.impl

import com.github.andreldsr.cartinhas.players.domain.player.PlayerRepository
import com.github.andreldsr.cartinhas.players.domain.team.TeamRepository
import com.github.andreldsr.cartinhas.season.application.playerseason.PlayerSeasonService
import com.github.andreldsr.cartinhas.season.application.playerseason.request.CreatePlayerSeasonRequest
import com.github.andreldsr.cartinhas.season.application.playerseason.request.toDomain
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeasonRepository
import com.github.andreldsr.cartinhas.season.domain.season.SeasonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlayerSeasonServiceImpl(
    private val repository: PlayerSeasonRepository,
    private val playerRepository: PlayerRepository,
    private val seasonRepository: SeasonRepository,
    private val teamRepository: TeamRepository
) : PlayerSeasonService {
    override fun save(request: CreatePlayerSeasonRequest): PlayerSeason {
        validateRequest(request)
        return repository.save(request.toDomain())
    }

    private fun validateRequest(request: CreatePlayerSeasonRequest) {
        if (!playerRepository.exists(request.playerId)) throw RuntimeException("Player not found")
        if (!seasonRepository.exists(request.seasonId)) throw RuntimeException("Season not found")
        if (!teamRepository.exists(request.teamId)) throw RuntimeException("Team not found")
    }

    override fun findById(id: UUID) = repository.findById(id)

    override fun findAll() = repository.findAll()

    override fun delete(id: UUID) = repository.delete(id)

    override fun update(id: UUID, playerSeason: PlayerSeason) = repository.update(id, playerSeason)
}
