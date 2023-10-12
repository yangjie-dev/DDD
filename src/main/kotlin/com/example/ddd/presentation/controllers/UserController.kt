package com.example.ddd.presentation.controllers

import com.example.ddd.presentation.dtos.UserRequestDto
import com.example.ddd.application.services.UserApplicationService
import com.example.ddd.presentation.dtos.UserResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(private val userApplicationService: UserApplicationService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userRequestDto: UserRequestDto): UserResponseDto {
        return userApplicationService.createUser(userRequestDto)
    }

    @GetMapping
    fun getUsers(): List<UserResponseDto> {
        return userApplicationService.getUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): ResponseEntity<UserResponseDto> {
        val userDto = userApplicationService.getUserById(id)
        if (userDto != null) {
            return ResponseEntity(userDto, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID) {
        userApplicationService.deleteById(id)
    }
}