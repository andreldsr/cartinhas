package com.github.andreldsr.cartinhas.card.presentation.card

import com.github.andreldsr.cartinhas.card.application.card.CardService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/cards")
class CardController(private val cardService: CardService) {
    @GetMapping
    @Operation(summary = "Find all cards", tags = ["Cards"], security = [SecurityRequirement(name = "bearer-key")])
    fun findAll() = cardService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find card by id", tags = ["Cards"], security = [SecurityRequirement(name = "bearer-key")])
    fun findById(@PathVariable id: UUID) = cardService.findById(id)
}
