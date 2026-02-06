package delvalle.valles.alejandro.examen2.exceptions;

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

    @ExceptionHandler(BusinessClienteException.class)
    public ResponseEntity<Map<String, String>> empleadoException(BusinessClienteException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BusinessClaseException.class)
    public ResponseEntity<Map<String, String>> empresaException(BusinessClaseException ex) {
        Map<String, String> message = new HashMap<>();
        message.put(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BusinessCarnetException.class)
    public ResponseEntity<Map<String, String>> cargoException(BusinessCarnetException ex) {
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
