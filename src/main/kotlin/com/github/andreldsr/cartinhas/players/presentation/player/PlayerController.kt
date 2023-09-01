package com.github.andreldsr.cartinhas.players.presentation.player

import com.github.andreldsr.cartinhas.players.application.player.PlayerService
import com.github.andreldsr.cartinhas.players.domain.player.Player
import com.github.andreldsr.cartinhas.user.infrastructure.UserDetailImpl
import io.micrometer.observation.annotation.Observed
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/players")
class PlayerController(private val playerService: PlayerService) {
    @GetMapping
    @Observed(name = "list_all_players")
    @Operation(summary = "List all players", tags = ["Players"], security = [SecurityRequirement(name = "bearer-key")])
    fun findAll(@AuthenticationPrincipal userDetails: UserDetailImpl): List<Player> {
        return playerService.findAll()
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find player by id", tags = ["Players"], security = [SecurityRequirement(name = "bearer-key")])
    fun findById(@PathVariable id: UUID) = playerService.findById(id)
}
