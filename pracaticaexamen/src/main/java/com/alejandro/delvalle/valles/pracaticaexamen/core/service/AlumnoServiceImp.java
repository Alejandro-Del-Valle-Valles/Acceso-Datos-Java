package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AlumnoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImp implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImp(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
}
