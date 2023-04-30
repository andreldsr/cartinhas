package com.github.andreldsr.cartinhas.draft.presentation

import com.github.andreldsr.cartinhas.draft.domain.DraftAlreadyExistsException
import com.github.andreldsr.cartinhas.draft.domain.DraftNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class DraftControllerAdvice {

    @ExceptionHandler
    fun handleDraftNotFound(exception: DraftNotFoundException): ProblemDetail {
        val pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND)
        pd.detail = exception.message
        return pd
    }

    @ExceptionHandler
    fun handleDraftAlreadyExists(exception: DraftAlreadyExistsException): ProblemDetail {
        val pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
        pd.detail = exception.message
        return pd
    }
}