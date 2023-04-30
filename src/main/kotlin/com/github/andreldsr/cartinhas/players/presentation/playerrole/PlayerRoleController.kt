package com.github.andreldsr.cartinhas.players.presentation.playerrole

import com.github.andreldsr.cartinhas.players.application.playerrole.PlayerRoleService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/player-roles")
class PlayerRoleController(
    private val playerRoleService: PlayerRoleService
) {
    @GetMapping
    @Operation(summary = "List all player roles", tags = ["Player Roles"])
    fun findAll() = playerRoleService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find player role by id", tags = ["Player Roles"])
    fun findById(@PathVariable id: UUID) = playerRoleService.findById(id)
}
