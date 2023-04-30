package com.github.andreldsr.cartinhas.user.infrastructure.persistence.role

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RoleJpaRepository : JpaRepository<RoleEntity, UUID>{
    fun findByName(name: String): RoleEntity
}
