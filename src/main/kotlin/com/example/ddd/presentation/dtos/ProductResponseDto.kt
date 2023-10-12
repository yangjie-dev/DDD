package com.example.ddd.presentation.dtos

import java.math.BigDecimal
import java.util.*

data class ProductResponseDto(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val unitPrice: BigDecimal
)