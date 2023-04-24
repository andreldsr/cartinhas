package com.github.andreldsr.cartinhas.season.domain.season

import java.util.UUID

interface SeasonRepository {
    fun findAll(): List<Season>
    fun findById(id: UUID): Season
    fun save(season: Season): Season
    fun update(id: UUID, season: Season): Season
    fun delete(id: UUID)
    fun exists(id: UUID): Boolean
    fun removeCurrent()
    fun setCurrent(id: UUID)
    fun getCurrent(): Season
}
