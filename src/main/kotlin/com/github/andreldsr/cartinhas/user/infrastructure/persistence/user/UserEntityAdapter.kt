package com.github.andreldsr.cartinhas.user.infrastructure.persistence.user

import com.github.andreldsr.cartinhas.user.domain.user.User
import com.github.andreldsr.cartinhas.user.infrastructure.UserDetailImpl
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.role.toDomain
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.role.toEntity

fun UserEntity.toDomain() = User(
    id, name, email, userPassword, roles.map { it.toDomain() }
)

fun UserEntity.toUserDetail() = UserDetailImpl(id!!, email, userPassword, roles)
fun User.toUserDetail() = UserDetailImpl(id!!, email, password, roles.map { it.toEntity() })
fun User.toEntity() = UserEntity(
    id, name, email, password, roles.map { it.toEntity() }
)
