package com.shugl.dmos;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDynamoDBRepositories(basePackages = "com.shugl.dmos.repository")
public class DmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmosApplication.class, args);
	}
}
