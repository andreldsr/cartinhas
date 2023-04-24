package com.github.andreldsr.cartinhas.players.domain.team

import java.util.UUID

interface TeamRepository {
    fun save(team: Team): Team
    fun findById(id: UUID): Team
    fun findAll(): List<Team>
    fun delete(id: UUID)
    fun update(id: UUID, team: Team): Team
    fun exists(id: UUID): Boolean
}
