package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @Autowired
    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }
}
