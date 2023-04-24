package com.github.andreldsr.cartinhas.card.domain.card

import java.util.UUID

interface CardRepository {
    fun findById(id: UUID): Card
    fun findAll(): List<Card>
    fun save(card: Card): Card
    fun delete(id: UUID)
    fun update(id: UUID, card: Card): Card
    fun exists(id: UUID): Boolean
}
