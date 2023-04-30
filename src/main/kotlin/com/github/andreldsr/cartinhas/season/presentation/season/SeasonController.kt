package com.github.andreldsr.cartinhas.season.presentation.season

import com.github.andreldsr.cartinhas.season.application.season.SeasonService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/seasons")
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
}
