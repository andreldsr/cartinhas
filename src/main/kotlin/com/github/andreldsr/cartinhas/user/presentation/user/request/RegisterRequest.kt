package com.github.andreldsr.cartinhas.user.presentation.user.request

data class RegisterRequest(
    val username: String,
    val name:  String,
    val password: String
)
