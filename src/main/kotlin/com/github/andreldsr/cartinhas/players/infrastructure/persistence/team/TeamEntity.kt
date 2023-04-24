package com.github.andreldsr.cartinhas.players.infrastructure.persistence.team

import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.PlayerSeasonEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.Hibernate
import java.util.UUID

@Entity(name = "teams")
data class TeamEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    val name: String,
    val image: String,
    val background: String,
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    val players: List<PlayerSeasonEntity> = emptyList()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as TeamEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
