package com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality

fun Nationality.toEntity() = NationalityEntity(id, name, flag)

fun NationalityEntity.toDomain() = Nationality(id, name, flag)
