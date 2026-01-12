package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.CarnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carnet")
public class CarnetController {

    private final CarnetService carentService;

    @Autowired
    public CarnetController(CarnetService carentService) {
        this.carentService = carentService;
    }
}
