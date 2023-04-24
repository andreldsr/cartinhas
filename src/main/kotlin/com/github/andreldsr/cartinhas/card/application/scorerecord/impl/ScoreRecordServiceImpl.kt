package com.github.andreldsr.cartinhas.card.application.scorerecord.impl

import com.github.andreldsr.cartinhas.card.application.scorerecord.ScoreRecordService
import com.github.andreldsr.cartinhas.card.domain.card.CardRepository
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecordRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ScoreRecordServiceImpl(
    private val scoreRecordRepository: ScoreRecordRepository,
    private val cardRepository: CardRepository
) : ScoreRecordService {
    override fun save(scoreRecord: ScoreRecord): ScoreRecord {
        if (!cardRepository.exists(scoreRecord.card.id!!)) {
            throw IllegalArgumentException("Card not found")
        }
        return scoreRecordRepository.save(scoreRecord)
    }

    override fun findById(id: UUID) = scoreRecordRepository.findById(id)

    override fun findAll() = scoreRecordRepository.findAll()

    override fun delete(id: UUID) = scoreRecordRepository.delete(id)

    override fun update(id: UUID, scoreRecord: ScoreRecord): ScoreRecord = scoreRecordRepository.update(id, scoreRecord)
}
