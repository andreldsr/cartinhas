package com.github.andreldsr.cartinhas.user.application.role

import com.github.andreldsr.cartinhas.user.domain.role.Role

interface RoleService {
    fun findAll(): List<Role>
    fun findByName(name: String): Role
}