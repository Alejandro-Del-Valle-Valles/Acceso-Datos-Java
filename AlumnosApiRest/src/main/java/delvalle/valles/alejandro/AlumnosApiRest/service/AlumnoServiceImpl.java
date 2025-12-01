package delvalle.valles.alejandro.AlumnosApiRest.service;

import delvalle.valles.alejandro.AlumnosApiRest.exceptions.AlumnoNotFoundException;
import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoRepository;
import delvalle.valles.alejandro.AlumnosApiRest.interfaces.AlumnoService;
import delvalle.valles.alejandro.AlumnosApiRest.model.Alumno;
import delvalle.valles.alejandro.AlumnosApiRest.model.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository repository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        return repository.findAll();
    }

    @Override
    public Alumno getAlumnoByNia(int nia) {
        return repository.findByNia(nia).orElseThrow(() -> new AlumnoNotFoundException(nia));
    }

    @Override
    public Alumno createAlumno(AlumnoDTO alumnoDTO) {
        return repository.save(new Alumno(alumnoDTO.getNia(), alumnoDTO.getName(),
                        alumnoDTO.getSurname(), alumnoDTO.getBornDate(), LocalDate.now()));
    }

    @Override
    public Alumno updateAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = getAlumnoByNia(alumnoDTO.getNia());
        return repository.update(new Alumno(alumnoDTO.getNia(), alumnoDTO.getName(), alumnoDTO.getSurname(),
                        alumnoDTO.getBornDate(), alumno.getRegistrationDate()))
                .orElseThrow(() -> new AlumnoNotFoundException(alumnoDTO.getNia()));
    }

    @Override
    public Alumno deleteAlumnoByNia(int nia) {
        return repository.deleteByNia(nia)
                .orElseThrow(() -> new AlumnoNotFoundException(nia));
    }
}
