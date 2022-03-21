package com.project.price.price.controller;

import com.project.price.price.dto.PriceApi;
import com.project.price.price.service.PriceService;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("v1/price")
@AllArgsConstructor
public class PriceController {

    private final MapperFacade mapper;
    private final PriceService priceService;

    @GetMapping
    private ResponseEntity<PriceApi> findPriceBy(
            @RequestParam(name = "application_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final LocalDateTime applicationDate,
            @RequestParam(name = "product_id") final Long productId,
            @RequestParam(name = "brand_id")  final Long brandId) {
        return ResponseEntity.ok(mapper.map(priceService.findPriceBy(applicationDate, productId, brandId), PriceApi.class));
    }
}
