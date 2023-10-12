package com.example.ddd.application.services

import com.example.ddd.application.mappers.UserDtoMapper.toDomain
import com.example.ddd.application.mappers.UserDtoMapper.toDto
import com.example.ddd.domain.order.services.OrderService
import com.example.ddd.domain.user.services.UserService
import com.example.ddd.presentation.dtos.UserRequestDto
import com.example.ddd.presentation.dtos.UserResponseDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserApplicationImplService(private val userService: UserService, private val orderService: OrderService) :
    UserApplicationService {
    override fun getUserById(id: UUID): UserResponseDto? {
        val user = userService.getUserById(id)
        return user?.toDto()
    }

    override fun createUser(userRequestDto: UserRequestDto): UserResponseDto {
        val user = userRequestDto.toDomain()
        val savedUser = userService.createUser(user)
        return savedUser.toDto()
    }

    override fun getUsers(): List<UserResponseDto> {
        val users = userService.getUsers();
        return users.map { user -> user.toDto() }
    }

    @Transactional
    override fun deleteById(id: UUID) {
        userService.deleteById(id)
    }
}