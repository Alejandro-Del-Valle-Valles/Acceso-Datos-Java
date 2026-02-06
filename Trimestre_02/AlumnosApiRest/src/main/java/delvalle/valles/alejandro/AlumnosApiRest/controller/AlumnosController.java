package delvalle.valles.alejandro.AlumnosApiRest.controller;

import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoService;
import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;
import delvalle.valles.alejandro.AlumnosApiRest.model.AlumnoDTO;
import delvalle.valles.alejandro.AlumnosApiRest.repository.AlumnoRepositoryMainMemory;
import delvalle.valles.alejandro.AlumnosApiRest.service.AlumnoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnosController {

    private AlumnoService service = new AlumnoServiceImpl(new AlumnoRepositoryMainMemory());

    @GetMapping
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok(service.getAllAlumnos());
    }

    @GetMapping("/{nia}")
    public ResponseEntity<Alumno> getAlumnoByNia(@PathVariable  int nia) {
        return ResponseEntity.ok(service.getAlumnoByNia(nia));
    }

    @PostMapping
    public ResponseEntity<Alumno> postNewAlumno(@Valid @RequestBody AlumnoDTO alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAlumno(alumno));
    }

    @PutMapping
    public ResponseEntity<Alumno> putAlumno(@Valid @RequestBody AlumnoDTO alumno) {
        return ResponseEntity.ok(service.updateAlumno(alumno));
    }

    @DeleteMapping("/{nia}")
    public ResponseEntity<Alumno> deleteAlumnoByNia(@PathVariable int nia) {
        return ResponseEntity.ok(service.deleteAlumnoByNia(nia));
    }
}
