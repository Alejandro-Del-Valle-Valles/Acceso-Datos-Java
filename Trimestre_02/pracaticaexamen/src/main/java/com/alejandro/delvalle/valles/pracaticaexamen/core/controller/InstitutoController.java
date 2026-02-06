package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.InstitutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituto")
public class InstitutoController {

    private final InstitutoService institutoService;

    @Autowired
    public InstitutoController(InstitutoService institutoService) {
        this.institutoService = institutoService;
    }

    @GetMapping
    public ResponseEntity<List<InstitutoDTO>> getAllInstitutos() {
        return ResponseEntity.ok(institutoService.getAll());
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public ResponseEntity<List<InstitutoDTO>> getAllInstitutosByUbicacion(@PathVariable String ubicacion) {
        return ResponseEntity.ok(institutoService.getAllByUbicacion(ubicacion));
    }

    @GetMapping("/nombreYubicacion")
    public ResponseEntity<InstitutoResumenDTO> getByNombreUbicacion(@RequestParam String nombre, @RequestParam String ubicacion) {
        return ResponseEntity.ok(institutoService.getByNombreUbicacion(nombre, ubicacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitutoResumenDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(institutoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<InstitutoDTO> createInstituto(@Valid @RequestBody InstitutoDTO instituto) {
        return ResponseEntity.ok(institutoService.createInstituto(instituto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitutoDTO> updateInsituto(@PathVariable int id, @Valid @RequestBody InstitutoDTO instituto) {
        return ResponseEntity.ok(institutoService.updateInstituo(id, instituto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<InstitutoResumenDTO> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(institutoService.deleteInstituoById(id));
    }
}
