package com.example.ddd.domain.product.services

import com.example.ddd.domain.product.models.entities.Product
import java.util.*

interface ProductService {
    fun getProductById(id: UUID): Product?
    fun createProduct(product: Product): Product
    fun getProducts(): List<Product>
    fun deleteById(id: UUID)
}