package com.wjahatadiltech.admin_management_service.service;

import com.wjahatadiltech.admin_management_service.dto.AirportDTO;
import com.wjahatadiltech.admin_management_service.dto.FlightDTO;
import com.wjahatadiltech.admin_management_service.entity.Airline;
import com.wjahatadiltech.admin_management_service.repository.AirlineRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class AdminService {

    private final RestTemplate restTemplate;
    private final AirlineRepository airlineRepository;

    public AdminService(RestTemplateBuilder builder, AirlineRepository airlineRepository) {
        this.restTemplate = builder.build();
        this.airlineRepository = airlineRepository;
    }

    public AirportDTO createAirport(AirportDTO airport) {
        String flightSearchServiceUrl = "http://localhost:8081/api/airports";
        return restTemplate.postForObject(flightSearchServiceUrl, airport, AirportDTO.class);
    }

    public void deleteAirport(Long id) {
        String flightSearchServiceUrl = "http://localhost:8081/api/airports/" + id;
        restTemplate.delete(flightSearchServiceUrl);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public List<AirportDTO> getAllAirports() {
        String flightSearchServiceUrl = "http://localhost:8081/api/airports";
        return Collections.singletonList(restTemplate.getForObject(flightSearchServiceUrl, AirportDTO.class));
    }

    public FlightDTO createFlight(FlightDTO flight) {
        String flightSearchServiceUrl = "http://localhost:8081/api/airports";
        return restTemplate.postForObject(flightSearchServiceUrl, flight, FlightDTO.class);
    }

    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<FlightDTO> getAllFlights() {
        String flightSearchServiceUrl = "http://localhost:8081/api/flights/search";
        return Collections.singletonList(restTemplate.getForObject(flightSearchServiceUrl, FlightDTO.class));
    }
}

