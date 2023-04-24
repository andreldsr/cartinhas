package com.github.andreldsr.cartinhas.card.application.card.impl

import com.github.andreldsr.cartinhas.card.application.card.CardService
import com.github.andreldsr.cartinhas.card.application.card.request.ChangeCardScoreRequest
import com.github.andreldsr.cartinhas.card.application.card.request.CreateCardRequest
import com.github.andreldsr.cartinhas.card.application.card.request.toDomain
import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.card.domain.card.CardFactory
import com.github.andreldsr.cartinhas.card.domain.card.CardRepository
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecordRepository
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeasonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
    private val playerSeasonRepository: PlayerSeasonRepository,
    private val scoreRecordRepository: ScoreRecordRepository
) : CardService {
    override fun findById(id: UUID) = cardRepository.findById(id)

    override fun findAll() = cardRepository.findAll()

    override fun save(request: CreateCardRequest): Card {
        validateCard(request)
        return cardRepository.save(request.toDomain())
    }

    private fun validateCard(request: CreateCardRequest) {
        if (!playerSeasonRepository.exists(request.playerSeasonId)) throw RuntimeException("Player not found")
    }

    override fun delete(id: UUID) = cardRepository.delete(id)

    override fun update(id: UUID, card: Card): Card = cardRepository.update(id, card)

    override fun updateScore(id: UUID, request: ChangeCardScoreRequest) {
        val card = cardRepository.findById(id)
        val highestScore = maxOf(card.lastScore, request.score)
        val diff = request.score - card.lastScore
        scoreRecordRepository.save(ScoreRecord(card = CardFactory.reference(id), score = request.score))
        cardRepository.update(id, card.copy(lastScore = request.score, highestScore = highestScore, lastDiff = diff))
    }

    override fun updateBagre(id: UUID) {
        cardRepository
            .findById(id)
            .let { card -> card.copy(bagres = card.bagres + 1) }
            .let { cardRepository.update(id, it) }
    }

    override fun updateCraque(id: UUID) {
        cardRepository
            .findById(id)
            .let { card -> card.copy(craques = card.craques + 1) }
            .let { cardRepository.update(id, it) }
    }
}
