package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CrearCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.CarnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/carnet")
public class CarnetController {

    private final CarnetService carnetService;

    @Autowired
    public CarnetController(CarnetService carnetService) {
        this.carnetService = carnetService;
    }

    @GetMapping
    public ResponseEntity<List<CarnetDTO>> getAll() {
        return ResponseEntity.ok(carnetService.getAll());
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<CarnetDTO>> getAllByColor(@PathVariable Colores color) {
        return ResponseEntity.ok(carnetService.getByColor(color));
    }

    @GetMapping("/{alumnoId}")
    public ResponseEntity<CarnetDTO> getByAlumnoId(@PathVariable int alumnoId) {
        return ResponseEntity.ok(carnetService.getByAlumnoId(alumnoId));
    }

    @PostMapping
    public ResponseEntity<CarnetDTO> createCarnet(@RequestBody CrearCarnetDTO crearCarnet, @RequestParam int alumnoId) {
        return ResponseEntity.ok(carnetService.createCarnet(crearCarnet, alumnoId));
    }

    @PutMapping
    public ResponseEntity<CarnetDTO> updateCarnet(@RequestParam Colores color, @RequestParam int alumnoId) {
        return ResponseEntity.ok(carnetService.updateCarnet(color, alumnoId));
    }

    @DeleteMapping("/{alumnoId}")
    public ResponseEntity<CarnetDTO> deleteCarnet(@PathVariable int alumnoId) {
        return ResponseEntity.ok(carnetService.deleteCarnet(alumnoId));
    }
}
