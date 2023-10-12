package com.example.ddd.application.services

import com.example.ddd.presentation.dtos.OrderRequestDto
import com.example.ddd.presentation.dtos.OrderResponseDto
import java.util.*

interface OrderApplicationService {
    fun getOrderById(id: UUID): OrderResponseDto?
    fun createOrder(orderRequestDto: OrderRequestDto): OrderResponseDto
    fun deleteById(id: UUID)
    fun getOrdersByUserId(userId: UUID): List<OrderResponseDto>
}