package com.wjahatadiltech.flight_search_service.service;


import com.wjahatadiltech.flight_search_service.entity.Flight;
import com.wjahatadiltech.flight_search_service.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findBySourceCodeAndDestinationCodeAndDepartureTimeBetween(
                source, destination, startDate, endDate);
    }
}

