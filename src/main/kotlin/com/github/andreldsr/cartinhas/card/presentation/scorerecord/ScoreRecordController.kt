package com.github.andreldsr.cartinhas.card.presentation.scorerecord

import com.github.andreldsr.cartinhas.card.application.scorerecord.ScoreRecordService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/score-records")
class ScoreRecordController(private val scoreRecordService: ScoreRecordService) {
    @GetMapping
    @Operation(summary = "List all score records", tags = ["Score Records"], security = [SecurityRequirement(name = "bearer-key")])
    fun findAll() = scoreRecordService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find score record by id", tags = ["Score Records"], security = [SecurityRequirement(name = "bearer-key")])
    fun findById(@PathVariable id: UUID) = scoreRecordService.findById(id)
}
