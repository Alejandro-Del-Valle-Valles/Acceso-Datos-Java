package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {

    List<Alumno> findByNombre(String nombre);
    List<Alumno> findByFechaNacimiento(LocalDate fecha);
    List<Alumno> findAlumnosByCentroNombreAndUbicacion(String nombre, String ubicacion);
    List<Alumno> findByAsignaturaNombre(String asignatura);
    Alumno findById(int id);
}
