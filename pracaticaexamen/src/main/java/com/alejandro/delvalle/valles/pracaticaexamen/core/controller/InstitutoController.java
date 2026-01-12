package com.alejandro.delvalle.valles.pracaticaexamen.core.controller;

import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.InstitutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instituto")
public class InstitutoController {

    private final InstitutoService institutoService;

    @Autowired
    public InstitutoController(InstitutoService institutoService) {
        this.institutoService = institutoService;
    }
}
