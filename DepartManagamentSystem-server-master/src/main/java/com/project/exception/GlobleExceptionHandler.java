package com.project.exception;

import com.project.payload.ApiRespons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiRespons> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

            String message = ex.getMessage();
            ApiRespons apiResponse = new ApiRespons(message,false);

            return new ResponseEntity<>(apiResponse , HttpStatus.NOT_FOUND);
        }

    }
