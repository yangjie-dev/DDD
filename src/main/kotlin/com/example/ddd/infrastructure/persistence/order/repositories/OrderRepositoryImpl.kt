package com.example.ddd.infrastructure.persistence.order.repositories

import com.example.ddd.domain.order.models.entities.Order
import com.example.ddd.domain.order.repositories.OrderRepository
import com.example.ddd.infrastructure.persistence.order.entities.OrderEntity
import com.example.ddd.infrastructure.persistence.order.mappers.OrderEntityMapper.toDomain
import com.example.ddd.infrastructure.persistence.order.mappers.OrderEntityMapper.toEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.jvm.optionals.getOrNull

interface OrderJpaRepository : JpaRepository<OrderEntity, UUID> {
    fun findAllByUserId(userId: UUID): List<OrderEntity>

    fun deleteAllByUserId(userId: UUID)
}

@Repository
class OrderRepositoryImpl(private var orderJpaRepository: OrderJpaRepository) : OrderRepository {
    override fun findById(id: UUID): Order? {
        val orderEntity = orderJpaRepository.findById(id).getOrNull()
        return orderEntity?.toDomain()
    }

    override fun findAll(): List<Order> {
        val orders = orderJpaRepository.findAll()
        return orders.map { o -> o.toDomain() }
    }

    override fun save(order: Order): Order {
        val orderEntity = order.toEntity()
        val savedOrder = orderJpaRepository.save(orderEntity)
        return savedOrder.toDomain()
    }

    override fun deleteById(id: UUID) {
        orderJpaRepository.deleteById(id)
    }


    override fun findAllByUserId(userId: UUID): List<Order> {
        return orderJpaRepository.findAllByUserId(userId).map { u -> u.toDomain() }
    }

    override fun deleteAllByUserId(userId: UUID) {
        orderJpaRepository.deleteAllByUserId(userId)
    }
}
