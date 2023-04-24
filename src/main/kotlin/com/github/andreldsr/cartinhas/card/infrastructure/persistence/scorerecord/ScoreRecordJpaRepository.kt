package com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ScoreRecordJpaRepository : JpaRepository<ScoreRecordEntity, UUID>
