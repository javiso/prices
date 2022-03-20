package com.project.price.price.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(final String message) {
        super(message);
    }
}