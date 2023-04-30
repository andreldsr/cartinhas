package com.github.andreldsr.cartinhas.user.infrastructure.persistence.role

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import org.springframework.security.core.GrantedAuthority
import java.util.UUID

@Entity
@Table(name = "role")
data class RoleEntity(
    @Id @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    val name: String
) : GrantedAuthority {
    override fun getAuthority() = name
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as RoleEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
