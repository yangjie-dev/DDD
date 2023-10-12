package com.example.ddd.application.mappers

import com.example.ddd.domain.product.models.entities.Product
import com.example.ddd.presentation.dtos.ProductRequestDto
import com.example.ddd.presentation.dtos.ProductResponseDto

object ProductDtoMapper {
    fun ProductRequestDto.toDomain(): Product {
        return Product(name = name, description = description, unitPrice = unitPrice )
    }

    fun Product.toDto(): ProductResponseDto {
        return ProductResponseDto(id, name, description, unitPrice)
    }
}