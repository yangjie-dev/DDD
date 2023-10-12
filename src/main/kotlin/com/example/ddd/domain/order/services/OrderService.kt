package com.example.ddd.domain.order.services

import com.example.ddd.domain.order.models.entities.Order
import com.example.ddd.domain.user.events.UserDeletedEvent
import java.util.*

interface OrderService {
    fun getOrderById(id: UUID): Order?
    fun createOrder(order: Order): Order
    fun findAllByUserId(userId: UUID):List<Order>
    fun deleteAllByUserId(userId: UUID)
    fun deleteById(id: UUID)
    fun handleUserDeletedEvent(event: UserDeletedEvent)
}