package com.github.andreldsr.cartinhas.season.application.season.impl

import com.github.andreldsr.cartinhas.season.application.season.SeasonService
import com.github.andreldsr.cartinhas.season.application.season.request.CreateSeasonRequest
import com.github.andreldsr.cartinhas.season.application.season.request.toDomain
import com.github.andreldsr.cartinhas.season.domain.season.Season
import com.github.andreldsr.cartinhas.season.domain.season.SeasonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeasonServiceImpl(private val seasonRepository: SeasonRepository) : SeasonService {
    override fun findAll() = seasonRepository.findAll()
    override fun findById(id: UUID) = seasonRepository.findById(id)
    override fun create(request: CreateSeasonRequest) = seasonRepository.save(request.toDomain())
    override fun update(id: UUID, season: Season): Season = seasonRepository.update(id, season)
    override fun delete(id: UUID) = seasonRepository.delete(id)
    override fun findCurrent() = seasonRepository.getCurrent()
    override fun setCurrent(id: UUID) {
        seasonRepository.removeCurrent()
        seasonRepository.setCurrent(id)
    }
}
