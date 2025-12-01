package delvalle.valles.alejandro.AlumnosApiRest.controller;

import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoRepository;
import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoService;
import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;
import delvalle.valles.alejandro.AlumnosApiRest.repository.AlumnoRepositoryMainMemory;
import delvalle.valles.alejandro.AlumnosApiRest.service.AlumnoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlumnosController {

    private AlumnoService service = new AlumnoServiceImpl(new AlumnoRepositoryMainMemory());

    @GetMapping("/alumno")
    public List<Alumno> getAlumnos() {
        return service.getAllAlumnos();
    }
}
