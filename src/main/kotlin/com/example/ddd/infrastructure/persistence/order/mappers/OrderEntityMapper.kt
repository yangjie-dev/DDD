package com.example.ddd.infrastructure.persistence.order.mappers

import com.example.ddd.domain.order.models.valueobjects.OrderStatus
import com.example.ddd.domain.order.models.entities.Order
import com.example.ddd.infrastructure.persistence.order.entities.OrderStatusEntity
import com.example.ddd.infrastructure.persistence.order.entities.OrderEntity
import com.example.ddd.infrastructure.persistence.order.mappers.OrderItemEntityMapper.toDomain
import com.example.ddd.infrastructure.persistence.order.mappers.OrderItemEntityMapper.toEntity

object OrderEntityMapper {
    fun OrderEntity.toDomain(): Order {
return Order(id, userId, orderItems.map { it.toDomain() }, enumValueOf<OrderStatus>(status.name), orderDate)
    }

    fun Order.toEntity(): OrderEntity {
        return OrderEntity(id,
            userId, orderItems.map { it.toEntity() }, enumValueOf<OrderStatusEntity>(status.name), orderDate)
    }
}