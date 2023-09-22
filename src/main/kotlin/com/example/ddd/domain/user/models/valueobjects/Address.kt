package com.example.ddd.domain.user.models.valueobjects

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String
)