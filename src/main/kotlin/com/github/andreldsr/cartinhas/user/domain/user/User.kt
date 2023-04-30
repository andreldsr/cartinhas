package com.github.andreldsr.cartinhas.user.domain.user

import com.github.andreldsr.cartinhas.user.domain.role.Role
import java.util.UUID

data class User(
    val id: UUID? = null,
    val name: String,
    val email: String,
    val password: String,
    val roles: List<Role> = emptyList()
)
