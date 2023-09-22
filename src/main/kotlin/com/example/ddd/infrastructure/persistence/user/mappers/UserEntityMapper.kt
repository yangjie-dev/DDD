package com.example.ddd.infrastructure.persistence.user.mappers

import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.infrastructure.persistence.user.entities.UserEntity
import com.example.ddd.infrastructure.persistence.user.mappers.AddressEntityMapper.toDomain
import com.example.ddd.infrastructure.persistence.user.mappers.AddressEntityMapper.toEntity

object UserEntityMapper {
    fun UserEntity.toDomain(): User {
        return User(id, name, addresses.map { it.toDomain() })
    }

    fun User.toEntity(): UserEntity {
        return UserEntity(id, name, addresses.map { it.toEntity() })
    }
}