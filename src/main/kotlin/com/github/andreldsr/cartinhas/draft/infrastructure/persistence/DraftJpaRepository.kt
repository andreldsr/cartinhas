package com.github.andreldsr.cartinhas.draft.infrastructure.persistence

import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.CardEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface DraftJpaRepository : JpaRepository<DraftEntity, UUID> {

    @Query("SELECT c FROM DraftEntity d JOIN d.cards c JOIN c.playerSeason ps JOIN ps.playerRole pr WHERE d.user.id = :id and pr.id = :roleId")
    fun findCardByIdAndCardsPlayerSeasonPlayerRoleId(id: UUID, roleId: UUID): Optional<CardEntity>

    @EntityGraph(attributePaths = ["cards"])
    fun findByUserId(userId: UUID): Optional<DraftEntity>

}
