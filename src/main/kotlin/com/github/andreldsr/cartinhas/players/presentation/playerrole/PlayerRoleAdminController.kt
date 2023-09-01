package com.github.andreldsr.cartinhas.players.presentation.playerrole

import com.github.andreldsr.cartinhas.players.application.playerrole.PlayerRoleService
import com.github.andreldsr.cartinhas.players.application.playerrole.request.CreatePlayerRoleRequest
import com.github.andreldsr.cartinhas.players.domain.playerrole.PlayerRole
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/admin/player-roles")
class PlayerRoleAdminController(
    private val playerRoleService: PlayerRoleService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save player role", tags = ["Player Roles"], security = [SecurityRequirement(name = "bearer-key")])
    fun save(@RequestBody request: CreatePlayerRoleRequest) = playerRoleService.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update player role", tags = ["Player Roles"], security = [SecurityRequirement(name = "bearer-key")])
    fun update(@PathVariable id: UUID, @RequestBody playerRole: PlayerRole) = playerRoleService.update(id, playerRole)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete player role", tags = ["Player Roles"], security = [SecurityRequirement(name = "bearer-key")])
    fun delete(@PathVariable id: UUID) = playerRoleService.delete(id)
}
