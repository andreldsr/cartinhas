package com.github.andreldsr.cartinhas.season.infrastructure.persistence.season

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface SeasonJpaRepository : JpaRepository<SeasonEntity, UUID> {
    @Modifying
    @Query("UPDATE SeasonEntity SET current = false")
    fun removeCurrent()

    @Modifying
    @Query("UPDATE SeasonEntity SET current = true WHERE id = :id")
    fun setCurrent(id: UUID)

    fun findByCurrentIsTrue(): Optional<SeasonEntity>
}
