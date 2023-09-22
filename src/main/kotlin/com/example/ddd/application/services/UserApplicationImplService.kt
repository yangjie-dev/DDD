package com.example.ddd.application.services

import com.example.ddd.application.mappers.UserDtoMapper.toDomain
import com.example.ddd.application.mappers.UserDtoMapper.toDto
import com.example.ddd.domain.user.services.UserService
import com.example.ddd.presentation.dtos.UserDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserApplicationImplService(private val userService: UserService) : UserApplicationService {
    override fun getUserById(id: UUID): UserDto? {
        val user = userService.getUserById(id)
        return user?.toDto()
    }

    override fun createUser(userDto: UserDto): UserDto {
        val user = userDto.toDomain()
        val savedUser = userService.createUser(user)
        return savedUser.toDto()
    }

    override fun getUsers(): List<UserDto> {
        val users = userService.getUsers();
        return users.map { user -> user.toDto() }
    }

    override fun deleteById(id: UUID) {
        userService.deleteById(id)
    }
}