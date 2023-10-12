package com.example.ddd.application.services

import com.example.ddd.presentation.dtos.UserRequestDto
import com.example.ddd.presentation.dtos.UserResponseDto
import java.util.*

interface UserApplicationService {
    fun getUserById(id: UUID): UserResponseDto?
    fun createUser(userRequestDto: UserRequestDto): UserResponseDto
    fun getUsers(): List<UserResponseDto>
    fun deleteById(id: UUID)
}