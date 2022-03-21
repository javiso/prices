package com.project.price.price.unitTest;

import com.project.price.price.exception.PriceNotFoundException;
import com.project.price.price.repository.PriceRepository;
import com.project.price.price.service.PriceService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceTest {

    private static PriceRepository priceRepository;
    private static ValidatorFactory validatorFactory;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        priceRepository = mock(PriceRepository.class);
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void checkPriceNotFoundException(){
        PriceService priceService = new PriceService(priceRepository);
        when(priceRepository.findPriceBy(anyLong(),anyLong(),any())).thenReturn(Optional.empty());
        PriceNotFoundException exception = assertThrows(PriceNotFoundException.class, () -> priceService.findPriceBy(LocalDateTime.now(),0L, 0L));
        assertTrue(exception.getMessage().contains("Price not found"));
    }
}