package com.example.ddd.infrastructure.persistence.product.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue
    val id: UUID,

    @Column(nullable = false)
    val name: String,

    @Column
    val description: String,

    @Column
    val unitPrice: BigDecimal
)