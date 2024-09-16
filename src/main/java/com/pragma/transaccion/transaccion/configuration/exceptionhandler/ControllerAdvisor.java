package com.pragma.transaccion.transaccion.configuration.exceptionhandler;


import com.pragma.transaccion.transaccion.adapters.driven.feigns.exception.NoNegativeStockException;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.transaccion.transaccion.configuration.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvisor {




  @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException(ElementNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(
                String.format(Constants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE,ex.getMessage()),
                HttpStatus.NOT_FOUND.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoNegativeStockException.class)
    public ResponseEntity<ExceptionResponse> handleNoNegativeStockException(NoNegativeStockException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
