package com.wjahatadiltech.admin_management_service.controller;

import com.wjahatadiltech.admin_management_service.dto.AirportDTO;
import com.wjahatadiltech.admin_management_service.dto.FlightDTO;
import com.wjahatadiltech.admin_management_service.entity.Airline;
import com.wjahatadiltech.admin_management_service.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Airline Endpoints
    @PostMapping("/airlines")
    public Airline createAirline(@RequestBody Airline airline) {
        return adminService.createAirline(airline);
    }

    @GetMapping("/airlines")
    public List<Airline> getAllAirlines() {
        return adminService.getAllAirlines();
    }

    // Airport Endpoints
    @PostMapping("/airports")
    public AirportDTO createAirport(@RequestBody AirportDTO airport) {
        return adminService.createAirport(airport);
    }

    @GetMapping("/airports")
    public List<AirportDTO> getAllAirports() {
        return adminService.getAllAirports();
    }

    // Flight Endpoints
    @PostMapping("/flights")
    public FlightDTO createFlight(@RequestBody FlightDTO flight) {
        return adminService.createFlight(flight);
    }

    @GetMapping("/flights")
    public List<FlightDTO> getAllFlights() {
        return adminService.getAllFlights();
    }
}
