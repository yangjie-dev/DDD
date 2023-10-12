package com.example.ddd.presentation.controllers

import com.example.ddd.application.services.OrderApplicationService
import com.example.ddd.presentation.dtos.OrderRequestDto
import com.example.ddd.presentation.dtos.OrderResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController(private val orderApplicationService: OrderApplicationService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody orderRequestDto: OrderRequestDto): OrderResponseDto {
        return orderApplicationService.createOrder(orderRequestDto)
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: UUID): ResponseEntity<OrderResponseDto> {
        val orderDto = orderApplicationService.getOrderById(id)
        if (orderDto != null) {
            return ResponseEntity(orderDto, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: UUID) {
        orderApplicationService.deleteById(id)
    }
}