package com.example.ddd.presentation.dtos

import java.math.BigDecimal

data class ProductRequestDto(
    val name: String,
    val description: String,
    val unitPrice: BigDecimal
)