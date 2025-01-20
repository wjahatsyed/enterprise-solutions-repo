package com.wjahatadiltech.flight_search_service.service;


import com.wjahatadiltech.flight_search_service.entity.Airport;
import com.wjahatadiltech.flight_search_service.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    /**
     * Create a new airport.
     *
     * @param airport the airport to create
     * @return the saved airport
     */
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    /**
     * Update an existing airport.
     *
     * @param id      the ID of the airport to update
     * @param airport the updated airport data
     * @return the updated airport
     * @throws RuntimeException if the airport with the given ID does not exist
     */
    public Airport updateAirport(Long id, Airport airport) {
        return airportRepository.findById(id).map(existingAirport -> {
            existingAirport.setCode(airport.getCode());
            existingAirport.setName(airport.getName());
            existingAirport.setCity(airport.getCity());
            existingAirport.setCountry(airport.getCountry());
            return airportRepository.save(existingAirport);
        }).orElseThrow(() -> new RuntimeException("Airport with ID " + id + " not found"));
    }

    /**
     * Delete an airport by ID.
     *
     * @param id the ID of the airport to delete
     * @throws RuntimeException if the airport with the given ID does not exist
     */
    public void deleteAirport(Long id) {
        if (!airportRepository.existsById(id)) {
            throw new RuntimeException("Airport with ID " + id + " not found");
        }
        airportRepository.deleteById(id);
    }

    /**
     * Get all airports.
     *
     * @return a list of all airports
     */
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
