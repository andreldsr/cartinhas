package com.github.andreldsr.cartinhas.players.presentation.team

import com.github.andreldsr.cartinhas.players.application.team.TeamService
import com.github.andreldsr.cartinhas.players.application.team.request.CreateTeamRequest
import com.github.andreldsr.cartinhas.players.domain.team.Team
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
@RequestMapping("/teams")
class TeamController(private val teamService: TeamService) {
    @GetMapping
    @Operation(summary = "List all teams", tags = ["Teams"])
    fun findAll() = teamService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find a team by id", tags = ["Teams"])
    fun findById(@PathVariable id: UUID) = teamService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new team", tags = ["Teams"])
    fun save(@RequestBody request: CreateTeamRequest) = teamService.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update a team", tags = ["Teams"])
    fun update(@PathVariable id: UUID, @RequestBody team: Team) = teamService.update(id, team)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a team", tags = ["Teams"])
    fun delete(@PathVariable id: UUID) = teamService.delete(id)
}
