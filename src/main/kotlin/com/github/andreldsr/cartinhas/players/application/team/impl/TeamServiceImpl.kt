package com.github.andreldsr.cartinhas.players.application.team.impl

import com.github.andreldsr.cartinhas.players.application.team.TeamService
import com.github.andreldsr.cartinhas.players.application.team.request.CreateTeamRequest
import com.github.andreldsr.cartinhas.players.application.team.request.toDomain
import com.github.andreldsr.cartinhas.players.domain.team.Team
import com.github.andreldsr.cartinhas.players.domain.team.TeamRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TeamServiceImpl(private val teamRepository: TeamRepository) : TeamService {
    override fun save(request: CreateTeamRequest) = teamRepository.save(request.toDomain())

    override fun findById(id: UUID) = teamRepository.findById(id)

    override fun findAll() = teamRepository.findAll()

    override fun delete(id: UUID) = teamRepository.delete(id)

    override fun update(id: UUID, team: Team) = teamRepository.update(id, team)
}
