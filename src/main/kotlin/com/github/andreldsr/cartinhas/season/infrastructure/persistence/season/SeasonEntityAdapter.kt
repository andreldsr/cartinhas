package com.github.andreldsr.cartinhas.season.infrastructure.persistence.season

import com.github.andreldsr.cartinhas.season.domain.season.Season

fun Season.toEntity() = SeasonEntity(id, name, current)
fun SeasonEntity.toDomain() = Season(id, name, current)
