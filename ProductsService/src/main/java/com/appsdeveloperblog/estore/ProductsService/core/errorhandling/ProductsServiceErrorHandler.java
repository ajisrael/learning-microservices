package com.appsdeveloperblog.estore.ProductsService.core.errorhandling;

import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ProductsServiceErrorHandler {

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException exception, WebRequest webRequest) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CommandExecutionException.class})
    public ResponseEntity<Object> handleCommandExecutionException(CommandExecutionException exception, WebRequest webRequest) {

        // Note: This works because axon framework stages events to be processed. So even though the exception is being thrown
        // after the event is applied to the aggregate lifecycle. The exception is being handled here before the event is dispatched
        // and handled in the event handler on the aggregate

        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception exception, WebRequest webRequest) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
