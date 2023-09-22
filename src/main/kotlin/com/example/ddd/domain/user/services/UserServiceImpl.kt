package com.example.ddd.domain.user.services

import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.domain.user.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getUserById(id: UUID): User? {
        return userRepository.findById(id)
    }

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun deleteById(id: UUID) {
        return userRepository.deleteById(id)
    }
}