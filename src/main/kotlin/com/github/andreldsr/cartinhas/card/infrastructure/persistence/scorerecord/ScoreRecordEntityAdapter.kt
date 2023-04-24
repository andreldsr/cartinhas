package com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord

import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toDomain
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toEntity

fun ScoreRecord.toEntity() = ScoreRecordEntity(
    id,
    card.toEntity(),
    score,
    date
)

fun ScoreRecordEntity.toDomain() = ScoreRecord(
    id,
    card!!.toDomain(),
    score,
    date
)
