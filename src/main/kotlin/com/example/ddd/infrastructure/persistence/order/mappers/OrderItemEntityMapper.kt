package com.example.ddd.infrastructure.persistence.order.mappers

import com.example.ddd.domain.order.models.entities.OrderItem
import com.example.ddd.infrastructure.persistence.order.entities.OrderItemEntity

object OrderItemEntityMapper {
    fun OrderItemEntity.toDomain(): OrderItem {
        return OrderItem(id, unitPrice, quantity, productId)
    }

    fun OrderItem.toEntity(): OrderItemEntity {
        return OrderItemEntity(id,  unitPrice, quantity, productId)
    }
}