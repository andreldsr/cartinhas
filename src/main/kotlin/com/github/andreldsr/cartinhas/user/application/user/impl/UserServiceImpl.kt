package com.github.andreldsr.cartinhas.user.application.user.impl

import com.github.andreldsr.cartinhas.user.application.user.UserService
import com.github.andreldsr.cartinhas.user.domain.role.RoleRepository
import com.github.andreldsr.cartinhas.user.domain.user.User
import com.github.andreldsr.cartinhas.user.domain.user.UserAlreadyExistsException
import com.github.andreldsr.cartinhas.user.domain.user.UserRepository
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.toUserDetail
import com.github.andreldsr.cartinhas.user.presentation.user.request.RegisterRequest
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService, UserDetailsService {
    override fun findAll() = userRepository.findAll()

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun findById(id: UUID) = userRepository.findById(id)

    override fun create(user: User) = userRepository.create(user)

    override fun update(id: UUID, user: User) = userRepository.update(id, user)

    override fun delete(id: UUID) = userRepository.delete(id)
    override fun registerNewUser(request: RegisterRequest): User {
        if (userRepository.existsByEmail(request.username)) throw UserAlreadyExistsException("User already exists")
        val role = roleRepository.findByName("ROLE_USER")
        val user = User(
            name = request.name,
            email = request.username,
            password = passwordEncoder.encode(request.password),
            roles = mutableListOf(role)
        )
        return userRepository.create(user)
    }

    override fun loadUserByUsername(username: String?) = userRepository.findByEmail(username ?: "").toUserDetail()
}