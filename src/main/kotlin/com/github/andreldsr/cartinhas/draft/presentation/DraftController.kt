package com.github.andreldsr.cartinhas.draft.presentation

import com.github.andreldsr.cartinhas.draft.application.DraftService
import com.github.andreldsr.cartinhas.draft.domain.request.CreateRequestDraft
import com.github.andreldsr.cartinhas.players.application.team.request.AddCardRequest
import com.github.andreldsr.cartinhas.user.infrastructure.UserDetailImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drafts")
class DraftController(val draftService: DraftService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new draft", tags = ["Draft"], security = [SecurityRequirement(name = "bearer-key")])
    fun createDraft(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: CreateRequestDraft) =
        draftService.createDraft(userDetails.id, request)

    @GetMapping
    @Operation(summary = "Find user's draft", tags = ["Draft"], security = [SecurityRequirement(name = "bearer-key")])
    fun findDraft(@AuthenticationPrincipal userDetails: UserDetailImpl) =
        draftService.findByUserId(userDetails.id)

    @PostMapping("/addCard")
    @Operation(
        summary = "Add card to draft",
        tags = ["Draft"],
        security = [SecurityRequirement(name = "bearer-key")]
    )
    fun addCard(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: AddCardRequest) =
        draftService.addCardToDraft(userDetails.id, request.cardId)

    @PostMapping("/removeCard")
    @Operation(
        summary = "Remove card from draft",
        tags = ["Draft"],
        security = [SecurityRequirement(name = "bearer-key")]
    )
    fun removeCard(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: AddCardRequest) =
        draftService.removeCardFromDraft(userDetails.id, request.cardId)
}