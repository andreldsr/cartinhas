package com.github.andreldsr.cartinhas.user.domain.user

import java.util.UUID

class UserFactory {
    companion object {
        fun reference(id: UUID) = empty().copy(id = id)
        fun empty() = User(name = "", email = "", password = "")
    }
}