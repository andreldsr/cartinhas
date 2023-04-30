package com.github.andreldsr.cartinhas.draft.domain

import com.github.andreldsr.cartinhas.user.domain.user.UserFactory
import java.util.UUID

class DraftFactory {
    companion object{
        fun userReference(id: UUID) = empty().copy(user = UserFactory.reference(id))
        fun empty() = Draft(name = "", user = UserFactory.empty())
    }
}