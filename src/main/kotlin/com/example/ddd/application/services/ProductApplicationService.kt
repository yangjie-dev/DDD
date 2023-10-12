package com.example.ddd.application.services

import com.example.ddd.presentation.dtos.ProductRequestDto
import com.example.ddd.presentation.dtos.ProductResponseDto
import java.util.*

interface ProductApplicationService {
    fun getProductById(id: UUID): ProductResponseDto?
    fun createProduct(productRequestDto: ProductRequestDto): ProductResponseDto
    fun getProducts(): List<ProductResponseDto>
    fun deleteById(id: UUID)
}