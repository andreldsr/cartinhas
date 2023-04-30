package com.github.andreldsr.cartinhas.draft.domain

import com.github.andreldsr.cartinhas.card.domain.card.Card
import com.github.andreldsr.cartinhas.user.domain.user.User
import java.util.UUID

data class Draft(
    val id: UUID? = null,
    val name: String,
    val user: User,
    val cards: List<Card> = emptyList()
)
