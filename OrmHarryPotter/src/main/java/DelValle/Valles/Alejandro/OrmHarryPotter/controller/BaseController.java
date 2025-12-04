package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping
    public String test() {
        return "Conexión exitosa";
    }
}
