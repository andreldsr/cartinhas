package com.github.andreldsr.cartinhas.user.domain.user

import java.util.UUID

interface UserRepository {
    fun findByEmail(email: String): User
    fun existsByEmail(email: String): Boolean
    fun findAll(): List<User>
    fun findById(id: UUID): User
    fun create(user: User): User
    fun update(id: UUID, user: User): User
    fun delete(id: UUID)
}