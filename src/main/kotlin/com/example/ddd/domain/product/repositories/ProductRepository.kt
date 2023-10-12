package com.example.ddd.domain.product.repositories

import com.example.ddd.domain.product.models.entities.Product
import java.util.*

interface ProductRepository {
    fun save(product: Product): Product
    fun findAll(): List<Product>
    fun findById(id: UUID): Product?
    fun deleteById(id: UUID)

}