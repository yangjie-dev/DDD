package com.example.ddd.application.mappers

import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.presentation.dtos.UserRequestDto
import com.example.ddd.presentation.dtos.UserResponseDto

object UserDtoMapper {
    fun UserRequestDto.toDomain(): User {
        return User(name = name)
    }

    fun User.toDto(): UserResponseDto {
        return UserResponseDto(id, name)
    }
}