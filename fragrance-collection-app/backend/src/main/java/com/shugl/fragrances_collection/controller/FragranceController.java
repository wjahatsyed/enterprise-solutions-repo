package com.shugl.fragrances_collection.controller;

import com.shugl.fragrances_collection.entity.Fragrance;
import com.shugl.fragrances_collection.service.FragranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fragrances")
@CrossOrigin(origins = "http://localhost:3000")
public class FragranceController {
    private final FragranceService fragranceService;

    public FragranceController(FragranceService fragranceService) {
        this.fragranceService = fragranceService;
    }

    @GetMapping
    public List<Fragrance> getAll() {
        return fragranceService.getAllFragrances();
    }

    @GetMapping("/{id}")
    public Fragrance getById(@PathVariable Long id) {
        return fragranceService.getFragranceById(id);
    }

    @PostMapping
    public Fragrance create(@RequestBody Fragrance fragrance) {
        return fragranceService.createFragrance(fragrance);
    }

    @PutMapping("/{id}")
    public Fragrance update(@PathVariable Long id, @RequestBody Fragrance fragrance) {
        return fragranceService.updateFragrance(id, fragrance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fragranceService.deleteFragrance(id);
        return ResponseEntity.noContent().build();
    }
}
