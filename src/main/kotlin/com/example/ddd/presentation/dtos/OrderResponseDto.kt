package com.example.ddd.presentation.dtos

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class OrderResponseDto(
    val orderId: UUID,
    val customerName: String,
    val orderItems: List<OrderItemResponseDto>,
    val orderStatus: String,
    val orderDate: LocalDateTime,
    val totalPrice: BigDecimal
)

class OrderItemResponseDto(
    val productId: UUID,
    val unitPrice: BigDecimal,
    val quantity: Int,
    val productName: String
)