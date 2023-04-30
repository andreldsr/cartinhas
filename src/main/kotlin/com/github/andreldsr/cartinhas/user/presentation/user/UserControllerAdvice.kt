package com.github.andreldsr.cartinhas.user.presentation.user

import com.github.andreldsr.cartinhas.user.domain.user.UserAlreadyExistsException
import com.github.andreldsr.cartinhas.user.domain.user.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserControllerAdvice {

    @ExceptionHandler
    fun handleUserNotFound(exception: UserNotFoundException): ProblemDetail {
        val pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND)
        pd.detail = exception.message
        return pd
    }

    @ExceptionHandler
    fun handleUserAlreadyExists(exception: UserAlreadyExistsException): ProblemDetail{
        val pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
        pd.detail = exception.message
        return pd
    }


}