package com.example.ddd.infrastructure.persistence.user.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue
    val id: UUID,

    val name: String,

    @ElementCollection
    @CollectionTable(name = "addresses", joinColumns = [JoinColumn(name = "user_id")])
    var addresses: List<AddressEntity> = mutableListOf()
)