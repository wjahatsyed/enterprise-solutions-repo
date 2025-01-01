package com.shugl.dmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmosApplication.class, args);
	}
}
