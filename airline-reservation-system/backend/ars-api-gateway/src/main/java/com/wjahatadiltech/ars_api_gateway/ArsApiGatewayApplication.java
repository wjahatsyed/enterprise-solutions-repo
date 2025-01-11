package com.wjahatadiltech.ars_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArsApiGatewayApplication.class, args);
	}

}
