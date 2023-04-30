package com.github.andreldsr.cartinhas.players.presentation.nationality

import com.github.andreldsr.cartinhas.players.application.nationality.NationalityService
import com.github.andreldsr.cartinhas.players.application.nationality.request.CreateNationalityRequest
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/admin/nationalities")
class NationalityAdminController(private val service: NationalityService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save a nationality", tags = ["Nationalities"])
    fun save(@RequestBody request: CreateNationalityRequest) = service.save(request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a nationality", tags = ["Nationalities"])
    fun delete(@PathVariable id: UUID) = service.delete(id)
}
