package com.github.andreldsr.cartinhas.card.domain.scorerecord

import java.util.UUID

interface ScoreRecordRepository {
    fun save(scoreRecord: ScoreRecord): ScoreRecord
    fun findById(id: UUID): ScoreRecord
    fun findAll(): List<ScoreRecord>
    fun delete(id: UUID)
    fun update(id: UUID, scoreRecord: ScoreRecord): ScoreRecord
}
