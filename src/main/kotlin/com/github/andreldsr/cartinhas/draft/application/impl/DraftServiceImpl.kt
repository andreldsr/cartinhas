package com.github.andreldsr.cartinhas.draft.application.impl

import com.github.andreldsr.cartinhas.card.domain.card.CardRepository
import com.github.andreldsr.cartinhas.draft.application.DraftService
import com.github.andreldsr.cartinhas.draft.domain.Draft
import com.github.andreldsr.cartinhas.draft.domain.DraftAlreadyExistsException
import com.github.andreldsr.cartinhas.draft.domain.DraftFactory
import com.github.andreldsr.cartinhas.draft.domain.DraftNotFoundException
import com.github.andreldsr.cartinhas.draft.domain.DraftRepository
import com.github.andreldsr.cartinhas.draft.domain.request.CreateRequestDraft
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DraftServiceImpl(val draftRepository: DraftRepository, val cardRepository: CardRepository) : DraftService {
    override fun createDraft(userId: UUID, request: CreateRequestDraft): Draft {
        if (draftRepository.findByUserId(userId) != null) throw DraftAlreadyExistsException("Draft already exists")
        val draft = DraftFactory.userReference(userId).copy(name = request.name)
        return draftRepository.createDraft(draft)
    }

    override fun findByUserId(userId: UUID): Draft {
        return draftRepository.findByUserId(userId) ?: throw DraftNotFoundException("Draft not found")
    }

    override fun addCardToDraft(userId: UUID, cardId: UUID): Draft {
        val card = cardRepository.findById(cardId)
        val cardOfRole = draftRepository.cardOfRole(userId, card.playerSeason.playerRole.id!!)
        if (cardOfRole != null)
            draftRepository.removeCard(userId, cardOfRole)
        return draftRepository.addCard(userId, card)
    }


    override fun removeCardFromDraft(userId: UUID, cardId: UUID): Draft =
        draftRepository.removeCard(userId, cardRepository.findById(cardId))
}