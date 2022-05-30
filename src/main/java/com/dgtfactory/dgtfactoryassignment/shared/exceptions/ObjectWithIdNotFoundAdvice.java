package com.dgtfactory.dgtfactoryassignment.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ObjectWithIdNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ObjectWithIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String objectNotFoundHandler(ObjectWithIdNotFoundException ex) {
        return ex.getMessage();
    }
}
