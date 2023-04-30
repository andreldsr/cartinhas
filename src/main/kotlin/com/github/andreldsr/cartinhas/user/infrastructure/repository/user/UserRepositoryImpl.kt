package com.github.andreldsr.cartinhas.user.infrastructure.repository.user

import com.github.andreldsr.cartinhas.user.domain.user.User
import com.github.andreldsr.cartinhas.user.domain.user.UserNotFoundException
import com.github.andreldsr.cartinhas.user.domain.user.UserRepository
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.UserJpaRepository
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.toDomain
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.toEntity
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepositoryImpl(private val userJpaRepository: UserJpaRepository) : UserRepository {
    override fun findByEmail(email: String): User = userJpaRepository
        .findByEmail(email)
        .map { it.toDomain() }
        .orElseThrow { UserNotFoundException("User not found") }

    override fun existsByEmail(email: String) = userJpaRepository.existsByEmail(email)

    override fun findAll() = userJpaRepository.findAll().map { it.toDomain() }

    override fun findById(id: UUID): User = userJpaRepository
        .findById(id)
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("User not found") }

    override fun create(user: User) = userJpaRepository
        .save(user.toEntity())
        .toDomain()

    override fun update(id: UUID, user: User): User = userJpaRepository
        .findById(id)
        .map { user.toEntity() }
        .map { userJpaRepository.save(it) }
        .map { it.toDomain() }
        .orElseThrow { RuntimeException("User not found") }

    override fun delete(id: UUID) = userJpaRepository.deleteById(id)
}