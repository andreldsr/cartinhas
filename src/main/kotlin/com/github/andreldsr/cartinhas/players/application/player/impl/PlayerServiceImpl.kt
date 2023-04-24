package com.github.andreldsr.cartinhas.players.application.player.impl

import com.github.andreldsr.cartinhas.players.application.player.PlayerService
import com.github.andreldsr.cartinhas.players.application.player.request.CreatePlayerRequest
import com.github.andreldsr.cartinhas.players.application.player.request.toDomain
import com.github.andreldsr.cartinhas.players.domain.nationality.NationalityRepository
import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.players.domain.player.PlayerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlayerServiceImpl(
    private val playerRepository: PlayerRepository,
    private val nationalityRepository: NationalityRepository
) : PlayerService {
    override fun create(request: CreatePlayerRequest): Player {
        if (!nationalityRepository.exists(request.nationalityId)) {
            throw IllegalArgumentException("Nationality not found")
        }
        return playerRepository.save(request.toDomain())
    }

    override fun findById(id: UUID): Player = playerRepository.findById(id)
    override fun findAll(): List<Player> = playerRepository.findAll()
    override fun update(id: UUID, player: Player) = playerRepository.update(id, player)

    override fun delete(id: UUID) = playerRepository.deleteById(id)
}
