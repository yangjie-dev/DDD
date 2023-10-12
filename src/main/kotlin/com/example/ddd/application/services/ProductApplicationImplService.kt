package com.example.ddd.application.services

import com.example.ddd.application.mappers.ProductDtoMapper.toDomain
import com.example.ddd.application.mappers.ProductDtoMapper.toDto
import com.example.ddd.domain.product.services.ProductService
import com.example.ddd.presentation.dtos.ProductRequestDto
import com.example.ddd.presentation.dtos.ProductResponseDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductApplicationImplService(private val productService: ProductService) : ProductApplicationService {
    override fun getProductById(id: UUID): ProductResponseDto? {
        val product = productService.getProductById(id)
        return product?.toDto()
    }

    override fun createProduct(productRequestDto: ProductRequestDto): ProductResponseDto {
        val product = productRequestDto.toDomain()
        val savedProduct = productService.createProduct(product)
        return savedProduct.toDto()
    }

    override fun getProducts(): List<ProductResponseDto> {
        val products = productService.getProducts();
        return products.map { product -> product.toDto() }
    }

    @Transactional
    override fun deleteById(id: UUID) {
        productService.deleteById(id)
    }
}