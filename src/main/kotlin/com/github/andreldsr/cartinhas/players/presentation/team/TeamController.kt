package com.github.andreldsr.cartinhas.players.presentation.team

import com.github.andreldsr.cartinhas.players.application.team.TeamService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/teams")
class TeamController(private val teamService: TeamService) {
    @GetMapping
    @Operation(summary = "List all teams", tags = ["Teams"], security = [SecurityRequirement(name = "bearer-key")])
    fun findAll() = teamService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find a team by id", tags = ["Teams"], security = [SecurityRequirement(name = "bearer-key")])
    fun findById(@PathVariable id: UUID) = teamService.findById(id)
}
