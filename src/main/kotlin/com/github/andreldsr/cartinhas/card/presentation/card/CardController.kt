package com.github.andreldsr.cartinhas.card.presentation.card

import com.github.andreldsr.cartinhas.card.application.card.CardService
import com.github.andreldsr.cartinhas.card.application.card.request.ChangeCardScoreRequest
import com.github.andreldsr.cartinhas.card.application.card.request.CreateCardRequest
import com.github.andreldsr.cartinhas.card.domain.card.Card
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
@RequestMapping("/cards")
class CardController(private val cardService: CardService) {
    @GetMapping
    @Operation(summary = "Find all cards", tags = ["Cards"])
    fun findAll() = cardService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Find card by id", tags = ["Cards"])
    fun findById(@PathVariable id: UUID) = cardService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save card", tags = ["Cards"])
    fun save(@RequestBody request: CreateCardRequest) = cardService.save(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update card", tags = ["Cards"])
    fun update(@PathVariable id: UUID, @RequestBody card: Card) = cardService.update(id, card)

    @PutMapping("/{id}/score")
    @Operation(summary = "Update card score", tags = ["Cards"])
    fun updateScore(@PathVariable id: UUID, @RequestBody request: ChangeCardScoreRequest) =
        cardService.updateScore(id, request)

    @PutMapping("/{id}/bagre")
    @Operation(summary = "Update card bagre", tags = ["Cards"])
    fun updateBagre(@PathVariable id: UUID) = cardService.updateBagre(id)

    @PutMapping("/{id}/craque")
    @Operation(summary = "Update card craque", tags = ["Cards"])
    fun updateCraque(@PathVariable id: UUID) = cardService.updateCraque(id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete card", tags = ["Cards"])
    fun delete(@PathVariable id: UUID) = cardService.delete(id)
}