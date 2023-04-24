package com.github.andreldsr.cartinhas.players.application.nationality.impl

import com.github.andreldsr.cartinhas.players.application.nationality.NationalityService
import com.github.andreldsr.cartinhas.players.application.nationality.request.CreateNationalityRequest
import com.github.andreldsr.cartinhas.players.application.nationality.request.toDomain
import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import com.github.andreldsr.cartinhas.players.domain.nationality.NationalityRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class NationalityServiceImpl(private val repository: NationalityRepository) : NationalityService {
    override fun findAll(page: Int, size: Int) = repository.getAll(page, size)
    override fun findById(id: UUID) = repository.get(id)

    override fun save(request: CreateNationalityRequest) = repository.save(request.toDomain())

    override fun delete(id: UUID) = repository.delete(id)
    override fun update(id: UUID, nationality: Nationality) = repository.update(id, nationality)
}
