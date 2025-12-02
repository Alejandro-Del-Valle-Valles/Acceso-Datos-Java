package delvalle.valles.alejandro.AlumnosApiRest.controller;

import delvalle.valles.alejandro.AlumnosApiRest.exceptions.AlumnoAlreadyExistsException;
import delvalle.valles.alejandro.AlumnosApiRest.exceptions.AlumnoNotFoundException;
import delvalle.valles.alejandro.AlumnosApiRest.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(AlumnoNotFoundException.class)
    public ResponseEntity<ErrorResponse> alumnoNotFound(AlumnoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(), "Alumno no encontrado"));
    }

    @ExceptionHandler(AlumnoAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> alumnoAlreayExists(AlumnoAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage(), "Alumno ya existente."));
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
    public ResponseEntity<String> exception(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
