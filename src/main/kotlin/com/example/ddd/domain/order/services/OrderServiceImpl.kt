package com.example.ddd.domain.order.services

import com.example.ddd.domain.order.models.entities.Order
import com.example.ddd.domain.user.events.UserDeletedEvent
import com.example.ddd.domain.order.repositories.OrderRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import java.util.*


@Service
class OrderServiceImpl(private val orderRepository: OrderRepository): OrderService {
    override fun getOrderById(id: UUID): Order? {
       return orderRepository.findById(id)
    }

    override fun createOrder(order: Order): Order {
       return orderRepository.save(order)
    }

    override fun findAllByUserId(userId: UUID): List<Order> {
       return orderRepository.findAllByUserId(userId)
    }

    override fun deleteAllByUserId(userId: UUID) {
       orderRepository.deleteAllByUserId(userId)
    }

    override fun deleteById(id: UUID) {
      orderRepository.deleteById(id)
    }

    @EventListener
    override fun handleUserDeletedEvent(event: UserDeletedEvent) {
        deleteAllByUserId(event.userId)
    }
}