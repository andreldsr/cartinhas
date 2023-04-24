package com.github.andreldsr.cartinhas.season.domain.playerseason

import java.util.UUID

interface PlayerSeasonRepository {
    fun save(playerSeason: PlayerSeason): PlayerSeason
    fun findById(id: UUID): PlayerSeason
    fun findAll(): List<PlayerSeason>
    fun delete(id: UUID)
    fun update(id: UUID, playerSeason: PlayerSeason): PlayerSeason
    fun exists(id: UUID): Boolean
}
