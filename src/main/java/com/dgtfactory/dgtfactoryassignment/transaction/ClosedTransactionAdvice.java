package com.dgtfactory.dgtfactoryassignment.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClosedTransactionAdvice {

    @ResponseBody
    @ExceptionHandler(ClosedTransactionException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String closedTransactionHandler(ClosedTransactionException ex) {
        return ex.getMessage();
    }
}
