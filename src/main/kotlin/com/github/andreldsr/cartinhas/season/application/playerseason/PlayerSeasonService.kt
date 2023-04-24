package com.github.andreldsr.cartinhas.season.application.playerseason

import com.github.andreldsr.cartinhas.season.application.playerseason.request.CreatePlayerSeasonRequest
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
import java.util.UUID

interface PlayerSeasonService {
    fun save(request: CreatePlayerSeasonRequest): PlayerSeason
    fun findById(id: UUID): PlayerSeason
    fun findAll(): List<PlayerSeason>
    fun delete(id: UUID)
    fun update(id: UUID, playerSeason: PlayerSeason): PlayerSeason
}
