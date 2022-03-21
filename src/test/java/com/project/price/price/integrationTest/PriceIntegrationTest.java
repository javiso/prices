package com.project.price.price.integrationTest;

import com.project.price.price.dto.PriceApi;
import com.project.price.price.util.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Integration test suite for price request and their operations")
public class PriceIntegrationTest {

    private static String URL = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkPriceTest1(){
        ParameterizedTypeReference<Map<String, String>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        String url = URL + port + "/v1/price";
        String uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("application_date", "2020-06-14 10:00:00")
                .queryParam("product_id","35455")
                .queryParam("brand_id","1")
                .build()
                .toUriString();

        ResponseEntity<PriceApi> response = restTemplate.exchange(uriComponentsBuilder, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), PriceApi.class, parameterizedTypeReference);
        PriceApi priceApi = response.getBody();

        assertEquals(1L,priceApi.getBrandId());
        assertEquals(35455L,priceApi.getProductId());
        assertEquals(new BigDecimal("35.50"),priceApi.getPrice());
        assertEquals("2020-06-14 00:00:00", DateUtil.toString(priceApi.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals("2020-12-31 23:59:59", DateUtil.toString(priceApi.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void checkPriceTest2(){
        ParameterizedTypeReference<Map<String, String>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        String url = URL + port + "/v1/price";
        String uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("application_date", "2020-06-14 16:00:00")
                .queryParam("product_id","35455")
                .queryParam("brand_id","1")
                .build()
                .toUriString();

        ResponseEntity<PriceApi> response = restTemplate.exchange(uriComponentsBuilder, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), PriceApi.class, parameterizedTypeReference);
        PriceApi priceApi = response.getBody();

        assertEquals(1L,priceApi.getBrandId());
        assertEquals(35455L,priceApi.getProductId());
        assertEquals(new BigDecimal("25.45"),priceApi.getPrice());
        assertEquals("2020-06-14 15:00:00", DateUtil.toString(priceApi.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals("2020-06-14 18:30:00", DateUtil.toString(priceApi.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void checkPriceTest3(){
        ParameterizedTypeReference<Map<String, String>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        String url = URL + port + "/v1/price";
        String uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("application_date", "2020-06-14 21:00:00")
                .queryParam("product_id","35455")
                .queryParam("brand_id","1")
                .build()
                .toUriString();

        ResponseEntity<PriceApi> response = restTemplate.exchange(uriComponentsBuilder, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), PriceApi.class, parameterizedTypeReference);
        PriceApi priceApi = response.getBody();

        assertEquals(1L,priceApi.getBrandId());
        assertEquals(35455L,priceApi.getProductId());
        assertEquals(new BigDecimal("35.50"),priceApi.getPrice());
        assertEquals("2020-06-14 00:00:00", DateUtil.toString(priceApi.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals("2020-12-31 23:59:59", DateUtil.toString(priceApi.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void checkPriceTest4(){
        ParameterizedTypeReference<Map<String, String>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        String url = URL + port + "/v1/price";
        String uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("application_date", "2020-06-15 10:00:00")
                .queryParam("product_id","35455")
                .queryParam("brand_id","1")
                .build()
                .toUriString();

        ResponseEntity<PriceApi> response = restTemplate.exchange(uriComponentsBuilder, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), PriceApi.class, parameterizedTypeReference);
        PriceApi priceApi = response.getBody();

        assertEquals(1L,priceApi.getBrandId());
        assertEquals(35455L,priceApi.getProductId());
        assertEquals(new BigDecimal("30.50"),priceApi.getPrice());
        assertEquals("2020-06-15 00:00:00", DateUtil.toString(priceApi.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals("2020-06-15 11:00:00", DateUtil.toString(priceApi.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void checkPriceTest5(){
        ParameterizedTypeReference<Map<String, String>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        String url = URL + port + "/v1/price";
        String uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("application_date", "2020-06-16 21:00:00")
                .queryParam("product_id","35455")
                .queryParam("brand_id","1")
                .build()
                .toUriString();

        ResponseEntity<PriceApi> response = restTemplate.exchange(uriComponentsBuilder, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), PriceApi.class, parameterizedTypeReference);
        PriceApi priceApi = response.getBody();

        assertEquals(1L,priceApi.getBrandId());
        assertEquals(35455L,priceApi.getProductId());
        assertEquals(new BigDecimal("38.95"),priceApi.getPrice());
        assertEquals("2020-06-15 16:00:00", DateUtil.toString(priceApi.getStartDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals("2020-12-31 23:59:59", DateUtil.toString(priceApi.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}