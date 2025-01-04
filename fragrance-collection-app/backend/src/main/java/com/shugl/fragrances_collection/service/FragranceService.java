package com.shugl.fragrances_collection.service;

import com.shugl.fragrances_collection.entity.Fragrance;
import com.shugl.fragrances_collection.repository.FragranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FragranceService {
    private final FragranceRepository fragranceRepository;

    public FragranceService(FragranceRepository fragranceRepository) {
        this.fragranceRepository = fragranceRepository;
    }

    public List<Fragrance> getAllFragrances() {
        return fragranceRepository.findAll();
    }

    public Fragrance getFragranceById(Long id) {
        return fragranceRepository.findById(id).orElseThrow(() -> new RuntimeException("Fragrance not found"));
    }

    public Fragrance createFragrance(Fragrance fragrance) {
        return fragranceRepository.save(fragrance);
    }

    public Fragrance updateFragrance(Long id, Fragrance fragrance) {
        Fragrance existing = getFragranceById(id);
        existing.setName(fragrance.getName());
        existing.setBrand(fragrance.getBrand());
        existing.setType(fragrance.getType());
        existing.setDescription(fragrance.getDescription());
        existing.setPrice(fragrance.getPrice());
        return fragranceRepository.save(existing);
    }

    public void deleteFragrance(Long id) {
        fragranceRepository.deleteById(id);
    }
}
