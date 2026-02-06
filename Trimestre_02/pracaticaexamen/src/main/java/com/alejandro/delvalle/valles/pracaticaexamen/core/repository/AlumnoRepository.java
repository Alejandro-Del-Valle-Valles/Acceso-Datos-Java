package com.alejandro.delvalle.valles.pracaticaexamen.core.repository;

import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {

    List<Alumno> findByNombreContainingIgnoreCase(String nombre);
    List<Alumno> findByFechaNacimiento(LocalDate fecha);
    List<Alumno> findByOrderByFechaNacimientoAsc();
    List<Alumno> findByOrderByFechaNacimientoDesc();
    List<Alumno> findByInstitutoUbicacionIgnoreCase(String ubicacion);
    List<Alumno> findByInstitutoNombreIgnoreCaseAndInstitutoUbicacionIgnoreCase(String nombre, String ubicacion);
    List<Alumno> findByAsignaturasNombre(String asignatura);
    Alumno findById(int id);
}
