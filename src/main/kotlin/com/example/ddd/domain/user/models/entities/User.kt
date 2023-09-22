package com.example.ddd.domain.user.models.entities

import com.example.ddd.domain.user.models.valueobjects.Address
import java.util.*

class User(val id: UUID = UUID.randomUUID(), val name: String, val addresses: List<Address> = mutableListOf())