package com.wjahatadiltech.admin_management_service.repository;

import com.wjahatadiltech.admin_management_service.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}

