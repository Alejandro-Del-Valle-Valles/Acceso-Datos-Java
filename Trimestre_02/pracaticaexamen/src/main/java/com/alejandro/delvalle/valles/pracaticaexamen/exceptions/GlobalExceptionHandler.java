package com.alejandro.delvalle.valles.pracaticaexamen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessAlumnoException.class)
    public ResponseEntity<Map<String, String>> alumnoException(BusinessAlumnoException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BusinessAsignaturaException.class)
    public ResponseEntity<Map<String, String>> asignaturaException(BusinessAsignaturaException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BusinessCarnetException.class)
    public ResponseEntity<Map<String, String>> carnetException(BusinessCarnetException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BusinessInstitutoException.class)
    public ResponseEntity<Map<String, String>> institutoException(BusinessInstitutoException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ':' + error.getDefaultMessage())
                .collect(Collectors.joining());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> exception(Exception ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}
