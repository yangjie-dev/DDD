package com.example.ddd.domain.user.repositories

import com.example.ddd.domain.user.models.entities.User
import java.util.*

interface UserRepository {
    fun save(user: User): User
    fun findAll(): List<User>
    fun findById(id: UUID): User?
    fun deleteById(id: UUID)

}