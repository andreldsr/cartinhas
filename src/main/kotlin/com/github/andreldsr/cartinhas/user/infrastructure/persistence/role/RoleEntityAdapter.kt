package com.github.andreldsr.cartinhas.user.infrastructure.persistence.role

import com.github.andreldsr.cartinhas.user.domain.role.Role

fun RoleEntity.toDomain() = Role(
    id, name
)

fun Role.toEntity() = RoleEntity(
    id, name
)