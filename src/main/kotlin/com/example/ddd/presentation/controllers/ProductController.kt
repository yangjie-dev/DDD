package com.example.ddd.presentation.controllers

import com.example.ddd.application.services.ProductApplicationService
import com.example.ddd.presentation.dtos.ProductRequestDto
import com.example.ddd.presentation.dtos.ProductResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController(private val productApplicationService: ProductApplicationService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody productDto: ProductRequestDto): ProductResponseDto {
        return productApplicationService.createProduct(productDto)
    }

    @GetMapping
    fun getProducts(): List<ProductResponseDto> {
        return productApplicationService.getProducts()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: UUID): ResponseEntity<ProductResponseDto> {
        val productDto = productApplicationService.getProductById(id)
        if (productDto != null) {
            return ResponseEntity(productDto, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: UUID) {
        productApplicationService.deleteById(id)
    }
}