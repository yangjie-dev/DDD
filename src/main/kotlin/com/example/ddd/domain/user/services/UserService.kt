package com.example.ddd.domain.user.services

import com.example.ddd.domain.user.models.entities.User
import java.util.UUID

interface UserService {
    fun getUserById(id: UUID): User?
    fun createUser(user: User): User
    fun getUsers(): List<User>
    fun deleteById(id: UUID)
    fun existsById(id: UUID): Any
}