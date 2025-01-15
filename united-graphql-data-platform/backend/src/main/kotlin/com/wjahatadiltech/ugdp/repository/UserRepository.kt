package com.wjahatadiltech.ugdp.repository

import com.wjahatadiltech.ugdp.entity.Property
import com.wjahatadiltech.ugdp.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
interface PropertyRepository : JpaRepository<Property, Long> {
    fun findByCity(city: String): List<Property>
}
