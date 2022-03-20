package com.project.price.price.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Excpetion. Please, see the following stacktrace: ", exception);
        ErrorApi apiError = new ErrorApi(HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorApi> handleMethodArgumentTypeMismatchException(Exception exception) {
        log.error("Excpetion. Please, see the following stacktrace: ", exception);
        ErrorApi apiError = new ErrorApi(HttpStatus.BAD_REQUEST, "Type argument not valid", Collections.singletonList(exception.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorApi> handleEntityNotFound(Exception exception) {
        log.error("Excpetion. Please, see the following stacktrace: ", exception);
        ErrorApi apiError = new ErrorApi(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}