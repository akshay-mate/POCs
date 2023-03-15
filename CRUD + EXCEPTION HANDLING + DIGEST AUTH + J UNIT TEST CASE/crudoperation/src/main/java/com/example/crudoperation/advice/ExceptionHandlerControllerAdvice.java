package com.example.crudoperation.advice;


import com.example.crudoperation.exception.EmptyInputException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> emptyInputHandler (EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Input fields are empty", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noElementHandler (NoSuchElementException noSuchElementException){
        return new ResponseEntity<String>("this Id is not present in database", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> resultNotFound (EmptyResultDataAccessException emptyResultDataAccessException){
        return new ResponseEntity<String>("this Record is not present in database,Please check it again", HttpStatus.NOT_FOUND);
    }

}
