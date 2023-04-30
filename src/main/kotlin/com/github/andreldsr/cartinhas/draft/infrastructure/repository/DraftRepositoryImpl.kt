package com.github.andreldsr.cartinhas.draft.infrastructure.repository

import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toDomain
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toEntity
import com.github.andreldsr.cartinhas.draft.domain.Draft
import com.github.andreldsr.cartinhas.draft.domain.DraftNotFoundException
import com.github.andreldsr.cartinhas.draft.domain.DraftRepository
import com.github.andreldsr.cartinhas.draft.infrastructure.persistence.DraftJpaRepository
import com.github.andreldsr.cartinhas.draft.infrastructure.persistence.toDomain
import com.github.andreldsr.cartinhas.draft.infrastructure.persistence.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class DraftRepositoryImpl(val draftJpaRepository: DraftJpaRepository) : DraftRepository {
    override fun findByUserId(id: UUID): Draft? = draftJpaRepository.findByUserId(id).map { it.toDomain() }.orElse(null)

    override fun createDraft(draft: Draft) = draftJpaRepository.save(draft.toEntity()).toDomain()

    override fun addCard(userId: UUID, card: Card): Draft {
        val draft = draftJpaRepository.findByUserId(userId)
            .orElseThrow { DraftNotFoundException("Draft not found for user $userId") }
        draft.cards.add(card.toEntity())
        return draftJpaRepository.save(draft).toDomain()
    }

    override fun removeCard(userId: UUID, card: Card): Draft {
        val draft = draftJpaRepository.findByUserId(userId)
            .orElseThrow { DraftNotFoundException("Draft not found for user $userId") }
        draft.cards.remove(card.toEntity())
        return draftJpaRepository.save(draft).toDomain()
    }

    override fun cardOfRole(userId: UUID, roleId: UUID): Card? {
        return draftJpaRepository.findCardByIdAndCardsPlayerSeasonPlayerRoleId(userId, roleId).map { it.toDomain() }
            .orElse(null)
    }
}