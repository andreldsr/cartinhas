package com.github.andreldsr.cartinhas.players.presentation.playerrole

import com.github.andreldsr.cartinhas.players.application.playerrole.PlayerRoleService
import com.github.andreldsr.cartinhas.players.application.playerrole.request.CreatePlayerRoleRequest
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/player-roles")
class PlayerRoleController(
    private val playerRoleService: PlayerRoleService
) {
    @GetMapping
    @Operation(summary = "List all player roles", tags = ["Player Roles"])
    fun findAll() = playerRoleService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find player role by id", tags = ["Player Roles"])
    fun findById(@PathVariable id: UUID) = playerRoleService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save player role", tags = ["Player Roles"])
    fun save(@RequestBody request: CreatePlayerRoleRequest) = playerRoleService.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update player role", tags = ["Player Roles"])
    fun update(@PathVariable id: UUID, @RequestBody playerRole: PlayerRole) = playerRoleService.update(id, playerRole)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete player role", tags = ["Player Roles"])
    fun delete(@PathVariable id: UUID) = playerRoleService.delete(id)
}
