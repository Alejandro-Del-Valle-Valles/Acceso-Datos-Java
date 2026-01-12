package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
}
