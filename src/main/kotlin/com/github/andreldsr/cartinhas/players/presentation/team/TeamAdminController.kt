package com.github.andreldsr.cartinhas.players.presentation.team

import com.github.andreldsr.cartinhas.players.application.team.TeamService
import com.github.andreldsr.cartinhas.players.application.team.request.CreateTeamRequest
import com.github.andreldsr.cartinhas.players.domain.team.Team
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
@RequestMapping("/api/admin/teams")
class TeamAdminController(private val teamService: TeamService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new team", tags = ["Teams"], security = [SecurityRequirement(name = "bearer-key")])
    fun save(@RequestBody request: CreateTeamRequest) = teamService.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update a team", tags = ["Teams"], security = [SecurityRequirement(name = "bearer-key")])
    fun update(@PathVariable id: UUID, @RequestBody team: Team) = teamService.update(id, team)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a team", tags = ["Teams"], security = [SecurityRequirement(name = "bearer-key")])
    fun delete(@PathVariable id: UUID) = teamService.delete(id)
}
