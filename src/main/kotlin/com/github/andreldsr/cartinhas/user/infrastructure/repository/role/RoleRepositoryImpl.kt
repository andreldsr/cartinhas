package com.github.andreldsr.cartinhas.user.infrastructure.repository.role

import com.github.andreldsr.cartinhas.user.domain.role.Role
import com.github.andreldsr.cartinhas.user.domain.role.RoleRepository
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.role.RoleJpaRepository
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.role.toDomain
import org.springframework.stereotype.Repository

@Repository
class RoleRepositoryImpl(private val roleJpaRepository: RoleJpaRepository) : RoleRepository {
    override fun findAll() = roleJpaRepository.findAll().map { it.toDomain() }

    override fun findByName(name: String): Role = roleJpaRepository.findByName(name).toDomain()
}