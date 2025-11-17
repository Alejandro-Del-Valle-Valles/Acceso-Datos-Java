package delvalle.valles.alejandro.mi_primer_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControler {

    @GetMapping("/world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "Hola " + name + "!";
    }

}
