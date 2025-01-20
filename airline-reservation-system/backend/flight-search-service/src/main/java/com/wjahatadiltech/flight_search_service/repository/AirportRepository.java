package com.wjahatadiltech.flight_search_service.repository;

import com.wjahatadiltech.flight_search_service.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
