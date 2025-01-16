package com.wjahatadiltech.ugdp

import com.wjahatadiltech.ugdp.entity.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.wjahatadiltech.ugdp.graphql.QueryResolver;
import com.wjahatadiltech.ugdp.repository.PropertyRepository
import com.wjahatadiltech.ugdp.repository.UserRepository
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import java.util.*

@SpringBootTest
class UgdpApplicationTests {
	private val userRepository: UserRepository = mock()
	private val propertyRepository: PropertyRepository = mock()
	private val queryResolver = QueryResolver(userRepository, propertyRepository)

	@Test
	fun contextLoads() {
	}

	@Test
	fun testGetUser() {
		// Arrange
		val userId = 1L
		val mockUser = User(id = userId, name = "Test User", email = "test_user@gmail.com")
		whenever(userRepository.findById(userId)).thenReturn(Optional.of(mockUser))

		// Act
		val user = queryResolver.getUser(userId)

		// Assert
		assertEquals(mockUser, user)
	}



}
