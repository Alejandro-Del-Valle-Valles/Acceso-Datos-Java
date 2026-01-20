package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.asignatura.AsignaturaResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @Autowired
    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok(asignaturaService.getAsignaturas());
    }

    //TODO: Cambiar modificación asignaturas
    @GetMapping("/resumen")
    public ResponseEntity<List<AsignaturaResumenDTO>> getAllResumen() {
        return ResponseEntity.ok(asignaturaService.getResumenAsignaturas());
    }

    @GetMapping("/contiene")
    public ResponseEntity<List<String>> getAsignaturasByWord(@RequestParam String palabra) {
        return ResponseEntity.ok(asignaturaService.getByNombreContains(palabra));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<AsignaturaResumenDTO> getByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(asignaturaService.getByNombre(nombre));
    }

    @PostMapping("/{nombre}")
    public ResponseEntity<AsignaturaResumenDTO> createAsignatura(@PathVariable String nombre) {
        return ResponseEntity.ok(asignaturaService.createAsignatura(nombre));
    }

    @PutMapping("/{nombreActual}/{nuevoNombre}")
    public ResponseEntity<AsignaturaResumenDTO> updateAsignatura(@PathVariable String nombreActual, @PathVariable String nuevoNombre) {
        return ResponseEntity.ok(asignaturaService.updateAsignatura(nombreActual, nuevoNombre));
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<AsignaturaResumenDTO> deleteAsignatura(@PathVariable String nombre) {
        return ResponseEntity.ok(asignaturaService.deleteAsignatura(nombre));
    }
}
