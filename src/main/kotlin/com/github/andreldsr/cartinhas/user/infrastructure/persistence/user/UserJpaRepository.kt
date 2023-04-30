package com.github.andreldsr.cartinhas.user.infrastructure.persistence.user

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserJpaRepository : JpaRepository<UserEntity, UUID> {
    @EntityGraph(attributePaths = ["roles"])
    fun findByEmail(email: String): Optional<UserEntity>
    fun existsByEmail(email: String): Boolean

}