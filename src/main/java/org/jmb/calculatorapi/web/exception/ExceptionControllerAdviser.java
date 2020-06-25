package org.jmb.calculatorapi.web.exception;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "org.jmb.calculatorapi.web")
public class ExceptionControllerAdviser {

    @ResponseBody
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ApiError operationNotImplemented(UnsupportedOperationException e) {
        return new ApiError(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiError validationException(UnsupportedOperationException e) {
        return new ApiError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
    }
}
