package com.example.ddd.presentation.controllers

import com.example.ddd.application.services.OrderApplicationService
import com.example.ddd.presentation.dtos.OrderResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserOrderController(private val orderApplicationService: OrderApplicationService) {
    @GetMapping("/{id}/orders")
    fun getOrderByUserId(@PathVariable id: UUID): ResponseEntity<List<OrderResponseDto>> {
        val ordersDto = orderApplicationService.getOrdersByUserId(id)
        if (ordersDto.isNotEmpty()) {
            return ResponseEntity(ordersDto, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}