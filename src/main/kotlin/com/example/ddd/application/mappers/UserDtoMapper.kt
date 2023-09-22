package com.example.ddd.application.mappers

import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.presentation.dtos.UserDto

object UserDtoMapper {
    fun UserDto.toDomain(): User {
        return User(name = name)
    }

    fun User.toDto(): UserDto {
        return UserDto(id, name)
    }
}