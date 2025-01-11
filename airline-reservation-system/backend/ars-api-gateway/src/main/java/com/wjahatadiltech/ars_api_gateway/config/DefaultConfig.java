package com.wjahatadiltech.ars_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class DefaultConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("flight-service", r -> r.path("/api/flights/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "Flight-Service"))
                        .uri("http://localhost:8081"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .filters(f -> f.addRequestParameter("gateway", "true"))
                        .uri("http://localhost:8082"))
                .build();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/api/auth/**").permitAll()  // Open routes
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .and()
                .and()
                .build();
    }
}
