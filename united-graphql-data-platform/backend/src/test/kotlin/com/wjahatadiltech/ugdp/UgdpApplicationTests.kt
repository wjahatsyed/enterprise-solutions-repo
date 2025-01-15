package com.wjahatadiltech.ugdp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.wjahatadiltech.ugdp.graphql.QueryResolver;

@SpringBootTest
class UgdpApplicationTests {
	@Autowired
	private lateinit var queryResolver: QueryResolver

	@Test
	fun contextLoads() {
	}

	@Test
	fun testGetUser() {
		val user = queryResolver.getUser(1L)
		assertEquals("John Doe", user.name)
	}


}
