package com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason

import com.github.andreldsr.cartinhas.players.infrastructure.persistence.player.PlayerEntity
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole.PlayerRoleEntity
import com.github.andreldsr.cartinhas.players.infrastructure.persistence.team.TeamEntity
import com.github.andreldsr.cartinhas.season.infrastructure.persistence.season.SeasonEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.hibernate.Hibernate
import java.util.UUID

@Entity(name = "player_seasons")
data class PlayerSeasonEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    @ManyToOne
    val player: PlayerEntity,
    @ManyToOne
    val season: SeasonEntity,
    @ManyToOne
    val team: TeamEntity,
    @ManyToOne
    val playerRole: PlayerRoleEntity,
    val image: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PlayerSeasonEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
