package com.github.andreldsr.cartinhas.user.domain.role

interface RoleRepository {
    fun findAll(): List<Role>
    fun findByName(name: String): Role
}