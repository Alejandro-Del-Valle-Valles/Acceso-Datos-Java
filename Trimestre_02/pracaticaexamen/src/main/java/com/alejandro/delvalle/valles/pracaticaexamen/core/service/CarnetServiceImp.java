package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.adapter.CarnetAdpater;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CrearCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Carnet;
import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AlumnoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.CarnetRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.CarnetService;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessAlumnoException;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessCarnetException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarnetServiceImp implements CarnetService {

    private final CarnetRepository carnetRepository;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public CarnetServiceImp(CarnetRepository carnetRepository, AlumnoRepository alumnoRepository) {
        this.carnetRepository = carnetRepository;
        this.alumnoRepository = alumnoRepository;
    }


    @Override
    public List<CarnetDTO> getAll() {
        return carnetRepository.findAll().stream()
                .map(CarnetAdpater::toDTO)
                .toList();
    }

    @Override
    public List<CarnetDTO> getByColor(Colores color) {
        return carnetRepository.findByColor(color).stream()
                .map(CarnetAdpater::toDTO)
                .toList();
    }

    @Override
    public CarnetDTO getByAlumnoId(int id) {
        Carnet carnet = carnetRepository.findByAlumnoId(id);
        if(carnet == null) throw new BusinessCarnetException(String.format("El alumno con ID %d no tiene un carnet asignado."
        ,id));
        return CarnetAdpater.toDTO(carnet);
    }

    @Override
    @Transactional
    public CarnetDTO createCarnet(CrearCarnetDTO crearCarnet, int id) {
        Alumno alumno = alumnoRepository.findById(id);
        if(alumno == null) throw new BusinessAlumnoException("El alumno con ID " + id + " no existe");
        else if (alumno.getCarnet() != null) throw new BusinessCarnetException("El alumno ya tiene un carnet asignado.");
        Carnet carnet = new Carnet();
        carnet.setColor(crearCarnet.getColor());
        carnet.setAlumno(alumno);
        alumno.setCarnet(carnet);
        carnetRepository.save(carnet);
        return CarnetAdpater.toDTO(carnet);
    }

    @Override
    public CarnetDTO updateCarnet(Colores color, int id) {
        Carnet carnet = carnetRepository.findByAlumnoId(id);
        if(carnet == null) throw new BusinessCarnetException("El alumno con ID " + id + " no existe o no tiene carnet asignado.");
        carnet.setColor(color);
        return CarnetAdpater.toDTO(carnet);
    }

    @Override
    public CarnetDTO deleteCarnet(int id) {
        Carnet carnet = carnetRepository.findByAlumnoId(id);
        if(carnet == null) throw new BusinessCarnetException("El alumno con ID " + id + " no existe o no tiene carnet asignado.");
        carnetRepository.delete(carnet);
        return CarnetAdpater.toDTO(carnet);
    }
}
