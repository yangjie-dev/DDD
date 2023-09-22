package com.example.ddd.infrastructure.persistence.user.mappers

import com.example.ddd.domain.user.models.valueobjects.Address
import com.example.ddd.infrastructure.persistence.user.entities.AddressEntity

object AddressEntityMapper {
    fun AddressEntity.toDomain(): Address {
        return Address(street,city,state, postalCode)
    }

    fun Address.toEntity(): AddressEntity {
        return AddressEntity(street,city,state, postalCode)
    }
}