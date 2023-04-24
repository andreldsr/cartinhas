package com.github.andreldsr.cartinhas.season.infrastructure.persistence.season

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.util.UUID

@Entity
@Table(name = "seasons")
data class SeasonEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    val name: String = "",
    val current: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SeasonEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
