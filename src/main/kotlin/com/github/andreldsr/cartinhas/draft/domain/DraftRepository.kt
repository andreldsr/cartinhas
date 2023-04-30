package com.github.andreldsr.cartinhas.draft.domain

import com.github.andreldsr.cartinhas.card.domain.card.Card
import java.util.UUID

interface DraftRepository {
    fun findByUserId(id: UUID): Draft?
    fun createDraft(draft: Draft): Draft
    fun addCard(userId: UUID, card: Card): Draft
    fun removeCard(userId: UUID, card: Card): Draft
    fun cardOfRole(userId: UUID, roleId: UUID): Card?

}