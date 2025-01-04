package com.shugl.fragrances_collection.repository;

import com.shugl.fragrances_collection.entity.Fragrance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FragranceRepository extends JpaRepository<Fragrance, Long> {
}
