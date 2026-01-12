package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.CarnetRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.CarnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarnetServiceImp implements CarnetService {

    private final CarnetRepository carnetRepository;

    @Autowired
    public CarnetServiceImp(CarnetRepository carnetRepository) {
        this.carnetRepository = carnetRepository;
    }
}
