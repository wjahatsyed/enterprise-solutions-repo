package com.wjahatadiltech.api_gateway;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiGatewayApplicationTests {

	@LocalServerPort
	private int port;

	private MockWebServer flightService;

	private WebClient webClient;

	@BeforeEach
	void setUp() throws Exception {
		flightService = new MockWebServer();
		flightService.start();
		webClient = WebClient.create("http://localhost:" + port);
	}

	@AfterEach
	void tearDown() throws Exception {
		flightService.shutdown();
	}

	@Test
	void testFlightServiceRoute() throws Exception {
		// Mock the Flight Service response
		flightService.enqueue(new MockResponse()
				.setBody("{\"status\":\"success\",\"data\":\"Flight details\"}")
				.addHeader("Content-Type", "application/json"));

		// Make a request through the Gateway
		String response = webClient.get()
				.uri("/api/flights/test")
				.retrieve()
				.bodyToMono(String.class)
				.block();

		// Assert the response
		assertThat(response).isEqualTo("{\"status\":\"success\",\"data\":\"Flight details\"}");
	}

	@Test
	void testInvalidRoute() {
		// Make a request to an undefined route
		String response = webClient.get()
				.uri("/invalid-route")
				.retrieve()
				.onStatus(status -> status.is4xxClientError(), clientResponse -> clientResponse.createException())
				.bodyToMono(String.class)
				.blockOptional()
				.orElse("Route not found");

		// Assert the response
		assertThat(response).isEqualTo("Route not found");
	}
}

