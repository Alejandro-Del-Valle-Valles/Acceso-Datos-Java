package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AsignaturaRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AsignaturaService;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImp implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImp(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }
}
