package com.github.andreldsr.cartinhas.players.infrastructure.repository.nationality

import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import com.github.andreldsr.cartinhas.players.domain.nationality.NationalityRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.NationalityJpaRepository
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.toDomain
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality.toEntity
import com.github.andreldsr.cartinhas.shared.Pagination
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class NationalityRepositoryImpl(private val repository: NationalityJpaRepository) : NationalityRepository {
    override fun get(id: UUID): Nationality {
        return repository
            .findById(id)
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Não encontrado") }
    }

    override fun getAll(page: Int, size: Int): Pagination<Nationality> {
        return repository
            .findAll(PageRequest.of(page, size))
            .let { Pagination(it.number, it.size, it.totalElements, it.content.map { n -> n.toDomain() }) }
    }

    override fun save(nationality: Nationality): Nationality {
        return repository
            .save(nationality.toEntity())
            .toDomain()
    }

    override fun update(id: UUID, nationality: Nationality): Nationality {
        return repository
            .findById(id)
            .map { nationality.toEntity() }
            .map { repository.save(it) }
            .map { it.toDomain() }
            .orElseThrow { RuntimeException("Nationality not found") }
    }

    override fun exists(id: UUID): Boolean {
        return repository.existsById(id)
    }

    override fun delete(id: UUID) {
        repository.deleteById(id)
    }
}
