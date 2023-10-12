package com.example.ddd.presentation.dtos

import java.util.*

data class OrderRequestDto(
    val userId: UUID,
    val items: List<OrderItemRequestDto>,
)

class OrderItemRequestDto(
    val productId: UUID,
    val quantity: Int
)