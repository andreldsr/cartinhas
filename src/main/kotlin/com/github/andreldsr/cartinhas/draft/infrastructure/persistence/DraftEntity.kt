package com.github.andreldsr.cartinhas.draft.infrastructure.persistence

import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.CardEntity
import com.github.andreldsr.cartinhas.user.infrastructure.persistence.user.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.util.UUID

@Entity
@Table(name = "draft")
data class DraftEntity(
    @Id @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    val name: String,
    @ManyToOne
    val user: UserEntity,
    @ManyToMany
    val cards: MutableList<CardEntity>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DraftEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
