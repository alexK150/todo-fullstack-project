package com.example.todofullstackproject.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;


@Service
//Service that map to String Validation Errors
public class MappedErrorsValidationService {

    public ResponseEntity<?> MappedErrorsValidationService(BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> mappedErrors = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                mappedErrors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(mappedErrors, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
