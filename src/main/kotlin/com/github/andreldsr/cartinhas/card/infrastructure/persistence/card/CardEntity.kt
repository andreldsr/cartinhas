package com.github.andreldsr.cartinhas.card.infrastructure.persistence.card

import com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason.PlayerSeasonEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.util.UUID

@Entity
@Table(name = "cards")
data class CardEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    @ManyToOne
    val playerSeason: PlayerSeasonEntity,
    val image: String,
    @Column(name = "last_score")
    val lastScore: Int,
    @Column(name = "last_diff")
    val lastDiff: Int,
    @Column(name = "highest_score")
    val highestScore: Int,
    val bagres: Int,
    val craques: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CardEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
