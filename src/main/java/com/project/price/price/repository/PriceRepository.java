package com.project.price.price.repository;

import com.project.price.price.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT * FROM Prices p WHERE p.product_id = :productId and p.brand_id = :brandId and p.start_date <= :applicationDate and p.end_date >= :applicationDate ORDER BY p.priority DESC limit 1",  nativeQuery = true)
    Optional<Price> findPriceBy(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate")LocalDateTime applicationDate);
}
