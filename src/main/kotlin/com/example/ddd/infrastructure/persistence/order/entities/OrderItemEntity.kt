package com.example.ddd.infrastructure.persistence.order.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "order_items")
class OrderItemEntity(
    @Id
    @GeneratedValue
    val id: UUID,

    @Column(nullable = false)
    val unitPrice: BigDecimal,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    var productId: UUID
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    lateinit var order: OrderEntity
}