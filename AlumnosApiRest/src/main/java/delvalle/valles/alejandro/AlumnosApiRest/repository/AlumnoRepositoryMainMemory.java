package delvalle.valles.alejandro.AlumnosApiRest.repository;

import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoRepository;
import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AlumnoRepositoryMainMemory implements AlumnoRepository {
    private Map<Integer, Alumno> alumnos = new HashMap<>();
    @Override
    public List<Alumno> findAll() {
        return alumnos.values().stream().toList();
    }

    @Override
    public Optional<Alumno> findByNia(int nia) {
        return Optional.of(alumnos.get(nia));
    }

    @Override
    public Alumno save(Alumno alumno) {
        Alumno newAlumno = null;
        if(!alumnos.containsKey(alumno.getNia())) newAlumno = alumnos.put(alumno.getNia(), alumno);
        return newAlumno;
    }

    @Override
    public Optional<Alumno> update(Alumno alumno) {
        Alumno oldAlumno = alumnos.replace(alumno.getNia(), alumno);
        return Optional.ofNullable(oldAlumno);
    }

    @Override
    public Optional<Alumno> deleteByNia(int nia) {
        Alumno deletedAlumno = alumnos.remove(nia);
        return Optional.ofNullable(deletedAlumno);
    }
}
