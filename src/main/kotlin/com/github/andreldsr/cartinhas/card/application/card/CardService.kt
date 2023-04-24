package com.github.andreldsr.cartinhas.card.application.card

import com.github.andreldsr.cartinhas.card.application.card.request.ChangeCardScoreRequest
import com.github.andreldsr.cartinhas.card.application.card.request.CreateCardRequest
import com.github.andreldsr.cartinhas.card.domain.card.Card
import java.util.UUID

interface CardService {
    fun findById(id: UUID): Card
    fun findAll(): List<Card>
    fun save(request: CreateCardRequest): Card
    fun delete(id: UUID)
    fun update(id: UUID, card: Card): Card
    fun updateScore(id: UUID, request: ChangeCardScoreRequest)
    fun updateBagre(id: UUID)
    fun updateCraque(id: UUID)
}
