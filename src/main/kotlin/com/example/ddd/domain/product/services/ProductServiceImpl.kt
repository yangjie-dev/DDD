package com.example.ddd.domain.product.services

import com.example.ddd.domain.product.models.entities.Product
import com.example.ddd.domain.product.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun getProductById(id: UUID): Product? {
        return productRepository.findById(id)
    }

    override fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun deleteById(id: UUID) {
        productRepository.deleteById(id)
    }
}