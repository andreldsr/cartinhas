package com.github.andreldsr.cartinhas.season.infrastructure.persistence.playerseason

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlayerSeasonJpaRepository : JpaRepository<PlayerSeasonEntity, UUID>
