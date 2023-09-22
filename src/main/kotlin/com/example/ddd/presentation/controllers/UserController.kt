package com.example.ddd.presentation.controllers

import com.example.ddd.presentation.dtos.UserDto
import com.example.ddd.application.services.UserApplicationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(private val userApplicationService: UserApplicationService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userDto: UserDto): UserDto {
        return userApplicationService.createUser(userDto)
    }

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userApplicationService.getUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): ResponseEntity<UserDto> {
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