package com.github.andreldsr.cartinhas.draft.infrastructure.persistence

import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toDomain
import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.toEntity
import com.github.andreldsr.cartinhas.draft.domain.Draft
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.toDomain
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.toEntity

fun DraftEntity.toDomain() = Draft(
    id, name, user.toDomain(), cards.map { it.toDomain() }
)

fun Draft.toEntity() = DraftEntity(
    id, name, user.toEntity(), cards.map { it.toEntity() }.toMutableList()
)
