package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.adapter.AlumnoAdapter;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import com.alejandro.delvalle.valles.pracaticaexamen.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<AlumnoDTO> alumnos = alumnoService.getAll()
                .stream()
                .map(AlumnoAdapter::toDTO)
                .toList();
        return ResponseEntity.ok(alumnos);
    }
}
