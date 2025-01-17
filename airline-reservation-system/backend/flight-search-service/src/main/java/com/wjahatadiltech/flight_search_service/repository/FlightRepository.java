package com.wjahatadiltech.flight_search_service.repository;


import com.wjahatadiltech.flight_search_service.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findBySourceCodeAndDestinationCodeAndDepartureTimeBetween(
            String sourceCode, String destinationCode, LocalDateTime startTime, LocalDateTime endTime);
}
