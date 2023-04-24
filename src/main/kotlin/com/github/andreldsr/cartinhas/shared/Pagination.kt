package com.github.andreldsr.cartinhas.shared

data class Pagination<T>(
    val page: Int,
    val size: Int,
    val total: Long,
    val content: List<T>
)
