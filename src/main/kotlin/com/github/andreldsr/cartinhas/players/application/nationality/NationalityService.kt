package com.github.andreldsr.cartinhas.players.application.nationality

import com.github.andreldsr.cartinhas.players.application.nationality.request.CreateNationalityRequest
import com.github.andreldsr.cartinhas.players.domain.nationality.Nationality
import com.github.andreldsr.cartinhas.shared.Pagination
import java.util.UUID

interface NationalityService {
    fun findAll(page: Int, size: Int): Pagination<Nationality>
    fun findById(id: UUID): Nationality
    fun save(request: CreateNationalityRequest): Nationality
    fun delete(id: UUID)
    fun update(id: UUID, nationality: Nationality): Nationality
}
