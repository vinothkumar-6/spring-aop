package com.getajob.springboot.restapicruddemo.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
    public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public final ResponseEntity<Error> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
            Error errorDetails = new Error(LocalDateTime.now(),
                    ex.getMessage(), request.getDescription(false));

            return new ResponseEntity<Error>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        @ExceptionHandler(UserNotFoundException.class)
        public final ResponseEntity<Error> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
            Error errorDetails = new Error(LocalDateTime.now(),
                    ex.getMessage(), request.getDescription(false));

            return new ResponseEntity<Error>(errorDetails, HttpStatus.NOT_FOUND);

        }
        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            Error errorDetails = new Error(LocalDateTime.now(),
                   ex.getErrorCount()+ "Errors: "+ex.getFieldError() +ex.getMessage(), request.getDescription(false));

            return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        }

        }

