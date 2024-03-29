package com.github.andreldsr.cartinhas.card.presentation.scorerecord

import com.github.andreldsr.cartinhas.card.application.scorerecord.ScoreRecordService
import com.github.andreldsr.cartinhas.card.domain.scorerecord.ScoreRecord
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
@RequestMapping("/api/admin/score-records")
class ScoreRecordAdminController(private val scoreRecordService: ScoreRecordService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create score record", tags = ["Score Records"], security = [SecurityRequirement(name = "bearer-key")])
    fun save(@RequestBody scoreRecord: ScoreRecord) = scoreRecordService.save(scoreRecord)

    @PutMapping("/{id}")
    @Operation(summary = "Update score record", tags = ["Score Records"], security = [SecurityRequirement(name = "bearer-key")])
    fun update(@PathVariable id: UUID, @RequestBody scoreRecord: ScoreRecord) =
        scoreRecordService.update(id, scoreRecord)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete score record", tags = ["Score Records"], security = [SecurityRequirement(name = "bearer-key")])
    fun delete(@PathVariable id: UUID) = scoreRecordService.delete(id)
}
