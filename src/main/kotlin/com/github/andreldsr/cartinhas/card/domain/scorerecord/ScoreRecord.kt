package com.github.andreldsr.cartinhas.card.domain.scorerecord

import com.github.andreldsr.cartinhas.card.domain.card.Card
import java.time.LocalDateTime
import java.util.UUID

data class ScoreRecord(
    val id: UUID? = null,
    val card: Card,
    val score: Int,
    val date: LocalDateTime = LocalDateTime.now()
)
