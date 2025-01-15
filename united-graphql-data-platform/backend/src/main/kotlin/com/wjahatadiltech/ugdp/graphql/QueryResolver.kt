package com.wjahatadiltech.ugdp.graphql

import com.wjahatadiltech.ugdp.entity.Property
import com.wjahatadiltech.ugdp.entity.User
import com.wjahatadiltech.ugdp.repository.PropertyRepository
import com.wjahatadiltech.ugdp.repository.UserRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class QueryResolver(
    private val userRepository: UserRepository,
    private val propertyRepository: PropertyRepository
) {

    fun getUser(id: Long): User = userRepository.findById(id).orElseThrow {
        IllegalArgumentException("User not found")
    }

    @Cacheable("properties")
    fun listProperties(city: String): List<Property> = propertyRepository.findByCity(city)
}
