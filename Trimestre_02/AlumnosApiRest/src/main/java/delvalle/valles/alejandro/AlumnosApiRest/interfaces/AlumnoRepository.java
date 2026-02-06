package delvalle.valles.alejandro.AlumnosApiRest.interfaces;

import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {

    List<Alumno> findAll();
    Optional<Alumno> findByNia(int nia);
    Alumno save(Alumno alumno);
    Optional<Alumno> update(Alumno alumno);
    Optional<Alumno> deleteByNia(int nia);
}
