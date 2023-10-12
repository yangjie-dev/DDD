package com.example.ddd.infrastructure.persistence.product.repositories

import com.example.ddd.domain.product.models.entities.Product
import com.example.ddd.domain.product.repositories.ProductRepository
import com.example.ddd.infrastructure.persistence.product.entities.ProductEntity
import com.example.ddd.infrastructure.persistence.product.mappers.ProductEntityMapper.toDomain
import com.example.ddd.infrastructure.persistence.product.mappers.ProductEntityMapper.toEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.jvm.optionals.getOrNull

interface ProductJpaRepository : JpaRepository<ProductEntity, UUID>

@Repository
class ProductRepositoryImpl(private var productJpaRepository: ProductJpaRepository) : ProductRepository {

    override fun save(product: Product): Product {
        val userEntity = product.toEntity()
        val savedProduct =  productJpaRepository.save(userEntity)
        return savedProduct.toDomain()
    }

    override fun findAll(): List<Product> {
        val users =  productJpaRepository.findAll()
        return users.map { user ->user.toDomain() }
    }


    override fun findById(id: UUID): Product? {
        val userEntity =  productJpaRepository.findById(id).getOrNull()
        return userEntity?.toDomain()
    }

    override fun deleteById(id: UUID) {
        productJpaRepository.deleteById(id)
    }
}
