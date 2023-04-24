package com.github.andreldsr.cartinhas.season.application.season

import com.github.andreldsr.cartinhas.season.application.season.request.CreateSeasonRequest
import com.github.andreldsr.cartinhas.season.domain.season.Season
import java.util.UUID

interface SeasonService {
    fun findAll(): List<Season>
    fun findById(id: UUID): Season
    fun create(request: CreateSeasonRequest): Season
    fun update(id: UUID, season: Season): Season
    fun delete(id: UUID)
    fun findCurrent(): Season
    fun setCurrent(id: UUID)
}
