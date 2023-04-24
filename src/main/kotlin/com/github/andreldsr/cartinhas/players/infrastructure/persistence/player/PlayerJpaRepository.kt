package com.github.andreldsr.cartinhas.players.infrastructure.persistence.player

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface PlayerJpaRepository : JpaRepository<PlayerEntity, UUID> {
    @EntityGraph(attributePaths = ["nationality"])
    override fun findAll(): MutableList<PlayerEntity>

    @EntityGraph(attributePaths = ["nationality"])
    override fun findById(id: UUID): Optional<PlayerEntity>
}
