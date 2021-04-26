package org.example.Islambek.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Islambek.exception.IncorrectIdException;
import org.example.Islambek.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IncorrectIdException.class)
    public ResponseEntity<ErrorResponse> handleDivideByZeroException(IncorrectIdException e) {
        log.error("Exception handled: " + e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("INCORRECT_ID_ERROR", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
