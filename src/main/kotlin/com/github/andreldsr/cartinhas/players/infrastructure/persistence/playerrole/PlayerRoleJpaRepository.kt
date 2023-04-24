package com.github.andreldsr.cartinhas.players.infrastructure.persistence.playerrole

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlayerRoleJpaRepository : JpaRepository<PlayerRoleEntity, UUID>
