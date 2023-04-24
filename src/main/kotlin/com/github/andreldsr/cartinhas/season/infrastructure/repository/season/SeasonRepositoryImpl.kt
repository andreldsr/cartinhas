package com.github.andreldsr.cartinhas.season.infrastructure.repository.season

import com.github.andreldsr.cartinhas.season.domain.season.Season
import com.github.andreldsr.cartinhas.season.domain.season.SeasonRepository
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.SeasonJpaRepository
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.toDomain
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class SeasonRepositoryImpl(
    private val seasonRepository: SeasonJpaRepository
) : SeasonRepository {
    override fun findAll(): List<Season> {
        return seasonRepository
            .findAll()
            .map { it.toDomain() }
    }

    override fun findById(id: UUID): Season {
        return seasonRepository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Season not found") }
    }

    override fun save(season: Season): Season {
        return seasonRepository
            .save(season.toEntity())
            .toDomain()
    }

    override fun update(id: UUID, season: Season): Season {
        return seasonRepository
            .findById(id)
            .map { season.toEntity() }
            .map { seasonRepository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Season not found") }
    }

    override fun delete(id: UUID) {
        seasonRepository.deleteById(id)
    }

    override fun exists(id: UUID): Boolean {
        return seasonRepository.existsById(id)
    }

    override fun removeCurrent() = seasonRepository.removeCurrent()

    override fun setCurrent(id: UUID) = seasonRepository.setCurrent(id)

    override fun getCurrent(): Season = seasonRepository
        .findByCurrentIsTrue()
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("Season not found") }
}
