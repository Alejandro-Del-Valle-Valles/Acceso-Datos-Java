package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAlumnos() {
        return ResponseEntity.ok(alumnoService.getAll());
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<AlumnoDTO>> getAlumnosByNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(alumnoService.getAlumnosByNombre(nombre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResumenDTO> getAlumnoById(@PathVariable int id) {
        return ResponseEntity.ok(alumnoService.getById(id));
    }

    @GetMapping("/nacimiento/{fecha}")
    public ResponseEntity<List<AlumnoDTO>> getByFechaNacimiento(@PathVariable LocalDate fecha) {
        return ResponseEntity.ok(alumnoService.getAlumnosByFechaNacimiento(fecha));
    }

    @GetMapping("/nacimiento")
    public ResponseEntity<List<AlumnoDTO>> getByFechaNacimientoOrdered(
            @RequestParam(required = false, defaultValue = "false") boolean ascendente) {
        return ResponseEntity.ok(alumnoService.getAlumnosByFechaNacimientoOrdered(ascendente));
    }

    @GetMapping("/instituto")
    public ResponseEntity<List<AlumnoDTO>> getAlumnosByInstituto(@RequestParam(required = false) String nombre,
                                                                 @RequestParam String ubicacion) {
        return ResponseEntity.ok( nombre != null
                ? alumnoService.getAlumnosByInstitutoNombreUbicacion(nombre, ubicacion)
                : alumnoService.getAlumnosByInstitutoUbicacion(ubicacion));
    }

    @GetMapping("/asigntaura/{asignatura}")
    public ResponseEntity<List<AlumnoResumenDTO>> getAlumnosByAsignatura(@PathVariable String asignatura) {
        return ResponseEntity.ok(alumnoService.getByAsignaturaNombre(asignatura));
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@Valid @RequestBody CrearAlumnoDTO alumno) {
        return ResponseEntity.ok(alumnoService.createAlumno(alumno));
    }

    @PostMapping("/carnet")
    public ResponseEntity<AlumnoDTO> createAlumnoCarnet(@Valid @RequestBody CrearAlumnoCarnetDTO alumno) {
        return ResponseEntity.ok(alumnoService.createAlumnoCarnet(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable int id, @Valid @RequestBody CrearAlumnoDTO alumno) {
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumno));
    }

    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<AlumnoResumenDTO> addAsignaturasToAlumno(@PathVariable int id, @RequestBody List<String> asignaturas) {
        return ResponseEntity.ok(alumnoService.addAsignaturasToAlumno(id, asignaturas));
    }

    @PutMapping("/{id}/{asignatura}")
    public  ResponseEntity<AlumnoResumenDTO> removeAsignatura(@PathVariable int id, @PathVariable String asignatura) {
        return ResponseEntity.ok(alumnoService.removeAsignaturaAlumno(id, asignatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoResumenDTO> deleteAlumno(@PathVariable int id) {
        return ResponseEntity.ok(alumnoService.deleteAlumnoById(id));
    }
}
