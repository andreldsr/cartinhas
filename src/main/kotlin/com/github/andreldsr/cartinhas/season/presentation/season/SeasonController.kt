package com.github.andreldsr.cartinhas.season.presentation.season

import com.github.andreldsr.cartinhas.season.application.season.SeasonService
import com.github.andreldsr.cartinhas.season.application.season.request.CreateSeasonRequest
import com.github.andreldsr.cartinhas.season.domain.season.Season
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
@RequestMapping("/seasons")
class SeasonController(private val seasonService: SeasonService) {
    @GetMapping
    @Operation(summary = "Find all seasons", tags = ["Seasons"])
    fun findAll() = seasonService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find season by id", tags = ["Seasons"])
    fun findById(@PathVariable id: UUID) = seasonService.findById(id)

    @GetMapping("/current")
    @Operation(summary = "Find current season", tags = ["Seasons"])
    fun findCurrent() = seasonService.findCurrent()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create season", tags = ["Seasons"])
    fun create(@RequestBody request: CreateSeasonRequest) = seasonService.create(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update season", tags = ["Seasons"])
    fun update(@PathVariable id: UUID, @RequestBody season: Season) = seasonService.update(id, season)

    @PutMapping("/current/{id}")
    @Operation(summary = "Set current season", tags = ["Seasons"])
    fun setCurrent(@PathVariable id: UUID) = seasonService.setCurrent(id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete season", tags = ["Seasons"])
    fun delete(@PathVariable id: UUID) = seasonService.delete(id)
}
