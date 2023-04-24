package com.github.andreldsr.cartinhas.card.infrastructure.persistence.card

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CardJpaRepository : JpaRepository<CardEntity, UUID>
