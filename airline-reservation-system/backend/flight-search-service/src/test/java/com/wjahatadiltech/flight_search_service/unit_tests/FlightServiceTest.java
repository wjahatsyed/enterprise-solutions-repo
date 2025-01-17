package com.wjahatadiltech.flight_search_service.unit_tests;


import com.wjahatadiltech.flight_search_service.entity.Flight;
import com.wjahatadiltech.flight_search_service.repository.FlightRepository;
import com.wjahatadiltech.flight_search_service.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightServiceTest {

    private final FlightRepository flightRepository = Mockito.mock(FlightRepository.class);
    private final FlightService flightService = new FlightService(flightRepository);

    @Test
    public void testSearchFlights() {
        String source = "JFK";
        String destination = "LAX";
        LocalDateTime startDate = LocalDateTime.parse("2025-01-20T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2025-01-21T00:00:00");

        Flight flight = new Flight();
        flight.setFlightNumber("AA101");
        flight.setPrice(300.00);

        Mockito.when(flightRepository.findBySourceCodeAndDestinationCodeAndDepartureTimeBetween(
                source, destination, startDate, endDate
        )).thenReturn(List.of(flight));

        List<Flight> result = flightService.searchFlights(source, destination, startDate, endDate);
        assertEquals(1, result.size());
        assertEquals("AA101", result.get(0).getFlightNumber());
    }
}
