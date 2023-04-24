package com.github.andreldsr.cartinhas.players.domain.nationality

import com.github.andreldsr.cartinhas.shared.Pagination
import java.util.UUID

interface NationalityRepository {
    fun get(id: UUID): Nationality
    fun getAll(page: Int, size: Int): Pagination<Nationality>
    fun save(nationality: Nationality): Nationality
    fun update(id: UUID, nationality: Nationality): Nationality
    fun exists(id: UUID): Boolean
    fun delete(id: UUID)
}
