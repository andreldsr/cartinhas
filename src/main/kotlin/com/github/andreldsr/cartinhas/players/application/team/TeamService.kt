package com.github.andreldsr.cartinhas.players.application.team

import com.github.andreldsr.cartinhas.players.application.team.request.CreateTeamRequest
import com.github.andreldsr.cartinhas.players.domain.team.Team
import java.util.UUID

interface TeamService {
    fun save(request: CreateTeamRequest): Team

    fun findById(id: UUID): Team

    fun findAll(): List<Team>

    fun delete(id: UUID)

    fun update(id: UUID, team: Team): Team
}
