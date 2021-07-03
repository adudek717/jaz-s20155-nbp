package com.example.jazs20155nbp.exception;

import com.example.jazs20155nbp.exception.custom.InvalidDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<String> getInvalidDateException(InvalidDateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> getHttpException(HttpClientErrorException ex){
        String message = ex.getLocalizedMessage();
        if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
            message = "Leak of data for that currency in that data range";
        }
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> getInternalServerError(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Something went wrong: " + ex.getLocalizedMessage());
    }
}
