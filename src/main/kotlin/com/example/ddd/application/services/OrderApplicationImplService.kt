package com.example.ddd.application.services

import com.example.ddd.application.mappers.OrderDtoMapper
import com.example.ddd.domain.product.services.ProductService
import com.example.ddd.domain.order.services.OrderService
import com.example.ddd.domain.user.services.UserService
import com.example.ddd.presentation.dtos.OrderRequestDto
import com.example.ddd.presentation.dtos.OrderResponseDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderApplicationImplService(
    private val orderService: OrderService,
    private val userService: UserService,
    private val productService: ProductService,
    private val orderDtoMapper: OrderDtoMapper
) : OrderApplicationService {
    override fun getOrderById(id: UUID): OrderResponseDto? {
        val order = orderService.getOrderById(id) ?: return null

        val user = userService.getUserById(order.userId)!!

        return orderDtoMapper.mapToDto(order, user, productService::getProductById)
    }

    override fun createOrder(orderRequestDto: OrderRequestDto): OrderResponseDto {
        val order = orderDtoMapper.mapToDomain(orderRequestDto, productService::getProductById)

        val createdOrder = orderService.createOrder(order)

        val user = userService.getUserById(order.userId)!!

        return orderDtoMapper.mapToDto(createdOrder, user, productService::getProductById)
    }

    override fun deleteById(id: UUID) {
        orderService.deleteById(id)
    }

    override fun getOrdersByUserId(userId: UUID): List<OrderResponseDto> {
        val user = userService.getUserById(userId)!!
        val orders = orderService.findAllByUserId(userId)

        return orderDtoMapper.mapToDto(orders, user, productService::getProductById)
    }
}