package com.github.andreldsr.cartinhas.draft.presentation

import com.github.andreldsr.cartinhas.draft.application.DraftService
import com.github.andreldsr.cartinhas.draft.domain.request.CreateRequestDraft
import com.github.andreldsr.cartinhas.players.application.team.request.AddCardRequest
import com.github.andreldsr.cartinhas.user.infrastructure.UserDetailImpl
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drafts")
class DraftController(val draftService: DraftService) {
    @PostMapping
    fun createDraft(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: CreateRequestDraft) =
        draftService.createDraft(userDetails.id, request)

    @GetMapping
    fun findDraft(@AuthenticationPrincipal userDetails: UserDetailImpl) =
        draftService.findByUserId(userDetails.id)

    @PostMapping("/addCard")
    fun addCard(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: AddCardRequest) =
        draftService.addCardToDraft(userDetails.id, request.cardId)

    @PostMapping("/removeCard")
    fun removeCard(@AuthenticationPrincipal userDetails: UserDetailImpl, @RequestBody request: AddCardRequest) =
        draftService.removeCardFromDraft(userDetails.id, request.cardId)
}