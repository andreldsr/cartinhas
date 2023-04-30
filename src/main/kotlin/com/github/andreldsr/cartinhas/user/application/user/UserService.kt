package com.github.andreldsr.cartinhas.user.application.user

import com.github.andreldsr.cartinhas.user.domain.user.User
import com.github.andreldsr.cartinhas.user.presentation.user.request.RegisterRequest
import java.util.UUID

interface UserService {
    fun findAll(): List<User>
    fun findByEmail(email: String): User
    fun findById(id: UUID): User
    fun create(user: User): User
    fun update(id: UUID, user: User): User
    fun delete(id: UUID)
    fun registerNewUser(request: RegisterRequest): User
}
