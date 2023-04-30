package com.github.andreldsr.cartinhas.user.presentation.user

import com.github.andreldsr.cartinhas.config.JWTUtils
import com.github.andreldsr.cartinhas.user.application.user.UserService
import com.github.andreldsr.cartinhas.user.presentation.user.request.AuthRequest
import com.github.andreldsr.cartinhas.user.presentation.user.request.RegisterRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val userDetailsService: UserDetailsService,
    private val jwtUtils: JWTUtils,
    private val authenticationManager: AuthenticationManager,
    private val userService: UserService
) {

    @PostMapping
    fun authenticate(@RequestBody request: AuthRequest): String {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
        val user = userDetailsService.loadUserByUsername(request.username)
        return jwtUtils.generateToken(user)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): String {
        val user = userService.registerNewUser(request)
        return jwtUtils.generateToken(userDetailsService.loadUserByUsername(user.email))
    }
}