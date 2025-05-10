package com.example.ecowatt.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Centralized exception handler for the Ecowatt API.
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {

    /**
     * Handles bean validation errors.
     *
     * @param exception validation exception
     * @return map with field and message
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorsMap = new HashMap<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return errorsMap;
    }

    /**
     * Handles data integrity violations, such as constraint errors.
     *
     * @return map with error message
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleDataIntegrity() {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Data integrity violation.");
        return errorMap;
    }
}
