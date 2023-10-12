package com.example.ddd.application.mappers

import com.example.ddd.domain.product.models.entities.Product
import com.example.ddd.domain.order.models.entities.Order
import com.example.ddd.domain.order.models.entities.OrderItem
import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.presentation.dtos.OrderItemResponseDto
import com.example.ddd.presentation.dtos.OrderRequestDto
import com.example.ddd.presentation.dtos.OrderResponseDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderDtoMapper {
    fun mapToDto(order: Order, user: User, getProduct: (UUID) -> Product?): OrderResponseDto {
        return OrderResponseDto(
            order.id,
            user.name,
            order.orderItems.map { o ->
                OrderItemResponseDto(
                    o.productId,
                    o.unitPrice,
                    o.quantity,
                    getProduct(o.productId)!!.name
                )
            },
            order.status.toString(),
            order.orderDate,
            order.calculateTotalPrice()
        )
    }

    fun mapToDto(orders: List<Order>, user: User, getProduct: (UUID) -> Product?): List<OrderResponseDto> {
        return orders.map { order -> mapToDto(order, user, getProduct) }
    }

    fun mapToDomain(orderRequestDto: OrderRequestDto, getProduct: (UUID) -> Product?): Order {
        return Order(
            userId = orderRequestDto.userId,
            orderItems = orderRequestDto.items.map { i ->
                OrderItem(
                    productId = i.productId,
                    quantity = i.quantity,
                    unitPrice = getProduct(i.productId)!!.unitPrice
                )
            })
    }
}