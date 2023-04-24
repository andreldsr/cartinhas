package com.github.andreldsr.cartinhas.players.infrastructure.persistence.team

import com.github.andreldsr.cartinhas.players.domain.team.Team

fun TeamEntity.toDomain() = Team(id, name, image, background)

fun Team.toEntity() = TeamEntity(id, name, image, background)
