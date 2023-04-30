package com.github.andreldsr.cartinhas.season.presentation.playerseason

import com.github.andreldsr.cartinhas.season.application.playerseason.PlayerSeasonService
import com.github.andreldsr.cartinhas.season.application.playerseason.request.CreatePlayerSeasonRequest
import com.github.andreldsr.cartinhas.season.domain.playerseason.PlayerSeason
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
@RequestMapping("/api/admin/player-seasons")
class PlayerSeasonAdminController(private val service: PlayerSeasonService) {
    @PostMapping
    @Operation(summary = "Save player season", tags = ["Player Seasons"])
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody request: CreatePlayerSeasonRequest) = service.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update player season", tags = ["Player Seasons"])
    fun update(@PathVariable id: UUID, @RequestBody playerSeason: PlayerSeason) = service.update(id, playerSeason)

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete player season", tags = ["Player Seasons"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) = service.delete(id)
}
