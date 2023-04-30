package com.github.andreldsr.cartinhas.players.presentation.player

import com.github.andreldsr.cartinhas.players.application.player.PlayerService
import com.github.andreldsr.cartinhas.players.application.player.request.CreatePlayerRequest
import com.github.andreldsr.cartinhas.players.domain.player.Player
import io.swagger.v3.oas.annotations.Operation
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
@RequestMapping("/api/admin/players")
class PlayerAdminController(private val playerService: PlayerService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create player", tags = ["Players"])
    fun create(@RequestBody request: CreatePlayerRequest) = playerService.create(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update player", tags = ["Players"])
    fun update(@PathVariable id: UUID, @RequestBody player: Player) = playerService.update(id, player)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete player", tags = ["Players"])
    fun delete(@PathVariable id: UUID) = playerService.delete(id)
}
