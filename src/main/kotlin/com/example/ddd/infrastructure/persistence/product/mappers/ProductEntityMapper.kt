package com.example.ddd.infrastructure.persistence.product.mappers

import com.example.ddd.domain.product.models.entities.Product
import com.example.ddd.infrastructure.persistence.product.entities.ProductEntity

object ProductEntityMapper {
    fun ProductEntity.toDomain(): Product {
        return Product(id, name, description, unitPrice)
    }

    fun Product.toEntity(): ProductEntity {
        return ProductEntity(id, name, description, unitPrice)
    }
}