package com.github.andreldsr.cartinhas.draft.application

import com.github.andreldsr.cartinhas.draft.domain.Draft
import com.github.andreldsr.cartinhas.draft.domain.request.CreateRequestDraft
import java.util.UUID

interface DraftService {
    fun createDraft(userId: UUID, request: CreateRequestDraft): Draft
    fun findByUserId(userId: UUID): Draft
    fun addCardToDraft(userId: UUID, cardId: UUID): Draft
    fun removeCardFromDraft(userId: UUID, cardId: UUID): Draft
}