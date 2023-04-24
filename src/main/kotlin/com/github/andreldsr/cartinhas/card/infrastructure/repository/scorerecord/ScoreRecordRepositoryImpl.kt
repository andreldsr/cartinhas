package com.github.andreldsr.cartinhas.card.infrastructure.repository.scorerecord

import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecordRepository
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord.ScoreRecordJpaRepository
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord.toDomain
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ScoreRecordRepositoryImpl(
    private val scoreRecordRepository: ScoreRecordJpaRepository
) : ScoreRecordRepository {
    override fun save(scoreRecord: ScoreRecord): ScoreRecord {
        return scoreRecordRepository
            .save(scoreRecord.toEntity())
            .toDomain()
    }

    override fun findById(id: UUID): ScoreRecord {
        return scoreRecordRepository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("ScoreRecord not found") }
    }

    override fun findAll(): List<ScoreRecord> {
        return scoreRecordRepository
            .findAll()
            .map { it.toDomain() }
    }

    override fun delete(id: UUID) {
        scoreRecordRepository.deleteById(id)
    }

    override fun update(id: UUID, scoreRecord: ScoreRecord): ScoreRecord {
        return scoreRecordRepository
            .findById(id)
            .map { scoreRecord.toEntity() }
            .map { scoreRecordRepository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("ScoreRecord not found") }
    }
}
