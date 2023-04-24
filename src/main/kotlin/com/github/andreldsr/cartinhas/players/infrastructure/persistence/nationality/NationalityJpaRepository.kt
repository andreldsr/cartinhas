package com.github.andreldsr.cartinhas.players.infrastructure.persistence.nationality

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface NationalityJpaRepository : JpaRepository<NationalityEntity, UUID>
