package com.github.andreldsr.cartinhas.card.infrastructure.persistence.scorerecord

import com.github.andreldsr.cartinhas.card.infrastructure.persistence.card.CardEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.Hibernate
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "score_records")
data class ScoreRecordEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,
    @ManyToOne
    val card: CardEntity? = null,
    val score: Int = 0,
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    val date: LocalDateTime = LocalDateTime.now()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ScoreRecordEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
