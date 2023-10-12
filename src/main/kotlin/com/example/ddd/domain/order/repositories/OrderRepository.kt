package com.example.ddd.domain.order.repositories

import com.example.ddd.domain.order.models.entities.Order
import java.util.*

interface OrderRepository {
    fun findAll(): List<Order>
    fun findById(id: UUID): Order?
    fun save(order: Order): Order
    fun deleteById(id: UUID)
    fun findAllByUserId(userId: UUID): List<Order>
    fun deleteAllByUserId(userId: UUID)
}