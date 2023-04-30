package com.github.andreldsr.cartinhas.players.presentation.nationality

import com.github.andreldsr.cartinhas.players.application.nationality.NationalityService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/nationalities")
class NationalityController(private val service: NationalityService) {
    @GetMapping
    @Operation(summary = "List all nationalities", tags = ["Nationalities"])
    fun findAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ) = service.findAll(page, size)

    @GetMapping("/{id}")
    @Operation(summary = "Find a nationality by id", tags = ["Nationalities"])
    fun findById(@PathVariable id: UUID) = service.findById(id)
}
