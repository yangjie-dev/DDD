package com.example.ddd.application.services

import com.example.ddd.presentation.dtos.UserDto
import java.util.*

interface UserApplicationService {
    fun getUserById(id: UUID): UserDto?
    fun createUser(userDto: UserDto): UserDto
    fun getUsers(): List<UserDto>
    fun deleteById(id: UUID)
}