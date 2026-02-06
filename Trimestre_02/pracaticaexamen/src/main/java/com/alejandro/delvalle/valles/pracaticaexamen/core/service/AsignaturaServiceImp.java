package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.adapter.AsignaturaAdapater;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.asignatura.AsignaturaResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Asignatura;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.AsignaturaRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.AsignaturaService;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessAsignaturaException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturaServiceImp implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImp(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }


    @Override
    public List<String> getAsignaturas() {
        return asignaturaRepository.findAll().stream()
                .map(Asignatura::getNombre)
                .toList();
    }

    @Override
    public List<AsignaturaResumenDTO> getResumenAsignaturas() {
        return asignaturaRepository.findAll().stream()
                .map(AsignaturaAdapater::toResumenDTO)
                .toList();
    }

    @Override
    public List<String> getByNombreContains(String nombre) {
        List<String> asignaturas = asignaturaRepository.findByNombreContainsIgnoreCase(nombre).stream()
                .map(Asignatura::getNombre)
                .toList();
        if(asignaturas.isEmpty()) throw new BusinessAsignaturaException("No existen asignaturas que contengan " + nombre);
        return asignaturas;
    }

    @Override
    public AsignaturaResumenDTO getByNombre(String nombre) {
        AsignaturaResumenDTO asignatura = AsignaturaAdapater.toResumenDTO(asignaturaRepository.findByNombreIgnoreCase(nombre));
        if(asignatura == null) throw new BusinessAsignaturaException(nombre + " no existe.");
        return asignatura;
    }

    @Override
    public AsignaturaResumenDTO createAsignatura(String nombre) {
        Asignatura asignatura = asignaturaRepository.findByNombreIgnoreCase(nombre);
        if(asignatura != null) throw new BusinessAsignaturaException(nombre + " ya existe");
        asignatura = new Asignatura(nombre, new ArrayList<>());
        asignaturaRepository.save(asignatura);
        return AsignaturaAdapater.toResumenDTO(asignatura);
    }

    @Override
    public AsignaturaResumenDTO updateAsignatura(String nombreActual, String nuevoNombre) {
        Asignatura asignatura = asignaturaRepository.findByNombreIgnoreCase(nombreActual);
        if(asignatura == null) throw new BusinessAsignaturaException(nombreActual + " no existe");
        asignatura.setNombre(nuevoNombre);
        asignaturaRepository.save(asignatura);
        return AsignaturaAdapater.toResumenDTO(asignatura);
    }

    @Override
    public AsignaturaResumenDTO deleteAsignatura(String nombre) {
        Asignatura asignatura = asignaturaRepository.findByNombreIgnoreCase(nombre);
        if(asignatura != null) throw new BusinessAsignaturaException(nombre + " no existe");
        asignaturaRepository.delete(asignatura);
        return AsignaturaAdapater.toResumenDTO(asignatura);
    }
}
