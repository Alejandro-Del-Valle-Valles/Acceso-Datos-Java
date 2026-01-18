package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.adapter.AlumnoAdapter;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.AlumnoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.alumno.CrearAlumnoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Alumno;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Carnet;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AlumnoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.InstitutoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AlumnoService;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessAlumnoException;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessInstitutoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImp implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final InstitutoRepository institutoRepository;

    @Autowired
    public AlumnoServiceImp(AlumnoRepository alumnoRepository, InstitutoRepository institutoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.institutoRepository = institutoRepository;
    }


    @Override
    public List<AlumnoDTO> getAll() {

        List<Alumno> alumnos = alumnoRepository.findAll();
        if(alumnos.isEmpty()) throw new BusinessAlumnoException("No se han encontrado alumnos.");

        return alumnos.stream().map(AlumnoAdapter::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> getAlumnosByNombre(String nombre) {
        List<Alumno> alumnos = alumnoRepository.findByNombreContainingIgnoreCase(nombre);
        if(alumnos.isEmpty()) throw new BusinessAlumnoException("No se han encontrado alumnos con el nombre " + nombre);

        return alumnos.stream().map(AlumnoAdapter::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> getAlumnosByFechaNacimiento(LocalDate fecha) {
        List<Alumno> alumnos = alumnoRepository.findByFechaNacimiento(fecha);
        if(alumnos.isEmpty()) throw new BusinessAlumnoException("No hay alumnos con fecha de nacimiento " + fecha);

        return alumnos.stream().map(AlumnoAdapter::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> getAlumnosByFechaNacimientoOrdered(boolean asc) {
        if(asc)
            return alumnoRepository.findByOrderByFechaNacimientoAsc().stream()
                .map(AlumnoAdapter::toDTO)
                .toList();
        else
            return alumnoRepository.findByOrderByFechaNacimientoDesc().stream()
                    .map(AlumnoAdapter::toDTO)
                    .toList();
    }

    @Override
    public List<AlumnoDTO> getAlumnosByInstitutoUbicacion(String ubicacion) {
        List<Alumno> alumnos = alumnoRepository.findByInstitutoUbicacionIgnoreCase(ubicacion);
        if(alumnos.isEmpty())
            throw new BusinessAlumnoException(String.format("No se han encontrado alumnos que estudien en %s",
                    ubicacion));

        return alumnos.stream().map(AlumnoAdapter::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> getAlumnosByInstitutoNombreUbicacion(String nombre, String ubicacion) {
        List<Alumno> alumnos = alumnoRepository.findByInstitutoNombreIgnoreCaseAndInstitutoUbicacionIgnoreCase(nombre, ubicacion);
        if(alumnos.isEmpty())
            throw new BusinessAlumnoException(String.format("No se han encontrado alumnos que estudien en %s, %s",
                    nombre, ubicacion));

        return alumnos.stream().map(AlumnoAdapter::toDTO).toList();
    }

    @Override
    public List<AlumnoResumenDTO> getByAsignaturaNombre(String asignatura) {
        List<Alumno> alumnos = alumnoRepository.findByAsignaturasNombre(asignatura);
        if(alumnos.isEmpty()) throw new BusinessAlumnoException("No se han encontrado alumnos que cursen " + asignatura);

        return alumnos.stream().map(AlumnoAdapter::toResumenDTO).toList();
    }

    @Override
    public AlumnoResumenDTO getById(int id) {
        Alumno alumno = alumnoRepository.findById(id);
        if(alumno == null) throw new BusinessAlumnoException("El alumno con ID " + id + " no se ha encontrado");
        return AlumnoAdapter.toResumenDTO(alumno);
    }

    @Override
    public AlumnoDTO createAlumno(CrearAlumnoDTO alumno) {
        Instituto instituto = institutoRepository.findByNombreAndUbicacion(alumno.getNombreInstituto(), alumno.getUbicacionInstituto());
        if(instituto == null)
            throw new BusinessInstitutoException(String.format("El instituto %s, %s no existe y no se puede asignar al alumno",
                alumno.getNombreInstituto(), alumno.getUbicacionInstituto()));
        Alumno nuevoAlumno = new Alumno(alumno.getNombre(), alumno.getFecha_nacimiento(), instituto, new ArrayList<>());
        alumnoRepository.save(nuevoAlumno);
        return AlumnoAdapter.toDTO(nuevoAlumno);
    }

    @Override
    @Transactional
    public AlumnoDTO createAlumnoCarnet(CrearAlumnoCarnetDTO alumno) {
        Instituto instituto = institutoRepository.findByNombreAndUbicacion(alumno.getNombreInstituto(), alumno.getUbicacionInstituto());
        if(instituto == null)
            throw new BusinessInstitutoException(String.format("El instituto %s, %s no existe y no se puede asignar al alumno",
                    alumno.getNombreInstituto(), alumno.getUbicacionInstituto()));
        Alumno nuevoAlumno = new Alumno(alumno.getNombre(), alumno.getFecha_nacimiento(), instituto, new ArrayList<>());
        Carnet carnet = new Carnet();
        carnet.setColor(alumno.getCarnet().getColor());
        nuevoAlumno.setCarnet(carnet);
        carnet.setAlumno(nuevoAlumno);
        alumnoRepository.save(nuevoAlumno);
        return AlumnoAdapter.toDTO(nuevoAlumno);
    }

    @Override
    public AlumnoDTO updateAlumno(int id, CrearAlumnoDTO alumno) {
        Alumno alumnoUpdate = alumnoRepository.findById(id);
        if(alumnoUpdate == null) throw new BusinessAlumnoException("El alumno con ID " + id + " no existe.");
        Instituto instituto = institutoRepository.findByNombreAndUbicacion(alumno.getNombreInstituto(), alumno.getUbicacionInstituto());
        if(instituto == null) throw new BusinessInstitutoException(String.format("El instituto %s, %s no existe.",
                alumno.getNombreInstituto(), alumno.getUbicacionInstituto()));
        Alumno nuevoAlumno = new Alumno(alumnoUpdate.getId(), alumno.getNombre(), alumno.getFecha_nacimiento(),
                alumnoUpdate.getCarnet(), instituto, alumnoUpdate.getAsignaturas());
        alumnoRepository.save(nuevoAlumno);
        return AlumnoAdapter.toDTO(nuevoAlumno);
    }

    @Override
    public AlumnoResumenDTO deleteAlumnoById(int id) {
        Alumno alumno = alumnoRepository.findById(id);
        if(alumno == null) throw new BusinessAlumnoException("El alumno con ID " + id + " no existe.");
        alumnoRepository.deleteById(id);
        return AlumnoAdapter.toResumenDTO(alumno);
    }
}
