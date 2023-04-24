package com.github.andreldsr.cartinhas.card.application.scorerecord

import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
import java.util.UUID

interface ScoreRecordService {
    fun save(scoreRecord: ScoreRecord): ScoreRecord
    fun findById(id: UUID): ScoreRecord
    fun findAll(): List<ScoreRecord>
    fun delete(id: UUID)
    fun update(id: UUID, scoreRecord: ScoreRecord): ScoreRecord
}
