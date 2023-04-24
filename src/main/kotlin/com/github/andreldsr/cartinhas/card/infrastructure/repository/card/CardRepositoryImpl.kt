package com.github.andreldsr.cartinhas.card.infrastructure.repository.card

import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.card.domain.card.CardRepository
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.CardJpaRepository
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toDomain
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CardRepositoryImpl(
    private val cardJpaRepository: CardJpaRepository
) : CardRepository {
    override fun findById(id: UUID): Card {
        return cardJpaRepository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Card not found") }
    }

    override fun findAll(): List<Card> {
        return cardJpaRepository
            .findAll()
            .map { it.toDomain() }
    }

    override fun save(card: Card): Card {
        return cardJpaRepository.save(card.toEntity()).toDomain()
    }

    override fun delete(id: UUID) {
        cardJpaRepository.deleteById(id)
    }

    override fun update(id: UUID, card: Card): Card {
        return cardJpaRepository
            .findById(id)
            .map { card.toEntity() }
            .map { cardJpaRepository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Card not found") }
    }

    override fun exists(id: UUID) = cardJpaRepository.existsById(id)
}
