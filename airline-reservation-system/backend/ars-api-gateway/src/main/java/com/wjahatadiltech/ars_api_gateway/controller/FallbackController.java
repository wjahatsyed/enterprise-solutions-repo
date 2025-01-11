package com.wjahatadiltech.ars_api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/flight")
    public String flightServiceFallback() {
        return "Flight Service is temporarily unavailable. Please try again later.";
    }
}

