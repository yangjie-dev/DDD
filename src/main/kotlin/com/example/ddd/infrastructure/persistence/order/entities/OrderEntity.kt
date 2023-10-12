package com.example.ddd.infrastructure.persistence.order.entities

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "orders")
class OrderEntity(
    @Id
    @GeneratedValue
    val id: UUID,

    @Column(nullable = false)
    val userId: UUID,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)//fetch = FetchType.LAZY
    val orderItems: List<OrderItemEntity> = mutableListOf(),

    @Enumerated(EnumType.STRING)
    var status: OrderStatusEntity = OrderStatusEntity.CREATED,

    @Column(nullable = false)
    val orderDate: LocalDateTime = LocalDateTime.now(),
)