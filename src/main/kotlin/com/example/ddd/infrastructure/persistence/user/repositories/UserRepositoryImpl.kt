package com.example.ddd.infrastructure.persistence.user.repositories

import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.domain.user.repositories.UserRepository
import com.example.ddd.infrastructure.persistence.user.mappers.UserEntityMapper.toDomain
import com.example.ddd.infrastructure.persistence.user.mappers.UserEntityMapper.toEntity
import com.example.ddd.infrastructure.persistence.user.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.jvm.optionals.getOrNull

interface UserJpaRepository : JpaRepository<UserEntity, UUID>

@Repository
class UserRepositoryImpl(private var userJpaRepository: UserJpaRepository) : UserRepository {

    override fun save(user: User): User {
        val userEntity = user.toEntity()
        val savedUser = userJpaRepository.save(userEntity)
        return savedUser.toDomain()
    }

    override fun findAll(): List<User> {
        val users = userJpaRepository.findAll()
        return users.map { user -> user.toDomain() }
    }


    override fun findById(id: UUID): User? {
        val userEntity = userJpaRepository.findById(id).getOrNull()
        return userEntity?.toDomain()
    }

    override fun deleteById(id: UUID) {
        userJpaRepository.deleteById(id)
    }

    override fun existsById(id: UUID) {
        userJpaRepository.existsById(id)
    }
}
