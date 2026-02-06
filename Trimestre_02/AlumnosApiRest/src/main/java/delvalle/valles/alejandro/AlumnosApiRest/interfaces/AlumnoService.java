package delvalle.valles.alejandro.AlumnosApiRest.interfaces;

import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;
import delvalle.valles.alejandro.AlumnosApiRest.model.AlumnoDTO;

import java.util.List;

public interface AlumnoService {

    List<Alumno> getAllAlumnos();
    Alumno getAlumnoByNia(int nia);
    Alumno createAlumno(AlumnoDTO alumnoDTO);
    Alumno updateAlumno(AlumnoDTO alumnoDTO);
    Alumno deleteAlumnoByNia(int nia);
}
