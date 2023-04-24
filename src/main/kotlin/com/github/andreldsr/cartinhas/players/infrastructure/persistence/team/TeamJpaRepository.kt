package com.github.andreldsr.cartinhas.players.infrastructure.persistence.team

import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.projection.TeamDetailsProjection
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface TeamJpaRepository : JpaRepository<TeamEntity, UUID> {
    fun findDetailById(id: UUID): Optional<TeamDetailsProjection>
}
