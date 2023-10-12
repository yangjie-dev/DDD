package com.example.ddd.domain.user.services

import com.example.ddd.domain.user.events.UserDeletedEvent
import com.example.ddd.domain.user.models.entities.User
import com.example.ddd.domain.user.repositories.UserRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(private val userRepository: UserRepository,private val eventPublisher: ApplicationEventPublisher) : UserService {
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
        userRepository.deleteById(id)

        val userDeletedEvent = UserDeletedEvent(id)

        eventPublisher.publishEvent(userDeletedEvent)
    }

    override fun existsById(id: UUID): Any {
        return userRepository.existsById(id)
    }
}