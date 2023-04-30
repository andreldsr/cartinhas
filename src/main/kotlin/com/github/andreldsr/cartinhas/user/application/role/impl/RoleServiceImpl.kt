package com.github.andreldsr.cartinhas.user.application.role.impl

import com.github.andreldsr.cartinhas.user.application.role.RoleService
import com.github.andreldsr.cartinhas.user.domain.role.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(private val roleRepository: RoleRepository) : RoleService {
    override fun findAll() = roleRepository.findAll()

    override fun findByName(name: String) = roleRepository.findByName(name)
}