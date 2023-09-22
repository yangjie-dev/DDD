package com.example.ddd.infrastructure.persistence.user.entities

import jakarta.persistence.Embeddable

@Embeddable
class AddressEntity(val street: String, val city: String, val state: String, val postalCode: String)
