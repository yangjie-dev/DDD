package com.example.ddd.domain.product.models.entities

import java.math.BigDecimal
import java.util.*

class Product(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val unitPrice: BigDecimal
)