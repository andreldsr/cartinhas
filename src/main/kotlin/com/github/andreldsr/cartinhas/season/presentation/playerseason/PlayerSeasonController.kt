package com.github.andreldsr.cartinhas.season.presentation.playerseason

import com.github.andreldsr.cartinhas.season.application.playerseason.PlayerSeasonService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/player-seasons")
class PlayerSeasonController(private val service: PlayerSeasonService) {
    @GetMapping
    @Operation(summary = "List all player seasons", tags = ["Player Seasons"])
    fun findAll() = service.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find player season by id", tags = ["Player Seasons"])
    fun findById(@PathVariable id: UUID) = service.findById(id)
}
