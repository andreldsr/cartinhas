package com.github.andreldsr.cartinhas.user.infrastructure

import com.github.andreldsr.cartinhas.user.infrastructure.persistence.role.RoleEntity
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

data class UserDetailImpl(
    val id: UUID,
    val email: String,
    val userPassword: String,
    val roles: List<RoleEntity>
) : UserDetails {
    override fun getAuthorities() = roles
    override fun getPassword() = userPassword
    override fun getUsername() = email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}
