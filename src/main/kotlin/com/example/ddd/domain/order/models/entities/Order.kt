package com.example.ddd.domain.order.models.entities

import com.example.ddd.domain.order.models.valueobjects.OrderStatus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


class Order(
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val orderItems: List<OrderItem> = mutableListOf(),
    var status: OrderStatus = OrderStatus.CREATED,
    val orderDate: LocalDateTime = LocalDateTime.now(),
) {
    fun calculateTotalPrice(): BigDecimal {
        val totalPrice = BigDecimal.ZERO
        orderItems.forEach { product ->
            totalPrice.add(product.unitPrice)
        }
        return totalPrice
    }

    fun completeOrder() {
        if (status != OrderStatus.CREATED) {
            throw IllegalStateException("Only orders with 'CREATED' status can be completed.")
        }

        status = OrderStatus.COMPLETED
    }

    fun cancelOrder() {
        if (status != OrderStatus.CREATED) {
            throw IllegalStateException("Only orders with 'CREATED' status can be canceled.")
        }

        status = OrderStatus.CANCELED
    }
}