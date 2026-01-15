package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AlumnoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlumnoServiceImp implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImp(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public List<Alumno> getAlumnosByNombre(String nombre) {
        return alumnoRepository.findByNombre(nombre);
    }

    @Override
    public List<Alumno> getAlumnosByFechaNacimiento(LocalDate fecha) {
        return alumnoRepository.findByFechaNacimiento(fecha);
    }

    @Override
    public List<Alumno> getAlumnosByCentroNombreUbicacion(String nombre, String ubicacion) {
        return alumnoRepository.findAlumnosByCentroNombreAndUbicacion(nombre, ubicacion);
    }

    @Override
    public List<Alumno> getByAsignaturaNombre(String asignatura) {
        return alumnoRepository.findByAsignaturaNombre(asignatura);
    }

    @Override
    public Alumno getAlumnoById(int id) {
        return alumnoRepository.findById(id);
    }
}
