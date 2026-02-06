package delvalle.valles.alejandro.ApiRestInicial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class WelcomeController {

    @GetMapping("")
    public String welcome() {
        return "Hola!";
    }

    @GetMapping("/now")
    public String getActualDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
