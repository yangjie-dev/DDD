package com.example.ddd.domain.order.models.entities

import java.math.BigDecimal
import java.util.*

class OrderItem(
    val id: UUID = UUID.randomUUID(),
    val unitPrice: BigDecimal,
    val quantity: Int,
    val productId: UUID
)