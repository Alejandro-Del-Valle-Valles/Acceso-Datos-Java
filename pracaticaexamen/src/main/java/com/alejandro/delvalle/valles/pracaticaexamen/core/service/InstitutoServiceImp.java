package com.alejandro.delvalle.valles.pracaticaexamen.core.service;

import com.alejandro.delvalle.valles.pracaticaexamen.adapter.InstitutoAdapter;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoResumenDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Instituto;
import com.alejandro.delvalle.valles.pracaticaexamen.core.repository.InstitutoRepository;
import com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces.InstitutoService;
import com.alejandro.delvalle.valles.pracaticaexamen.exceptions.BusinessInstitutoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutoServiceImp implements InstitutoService {

    private final InstitutoRepository institutoRepository;

    @Autowired
    public InstitutoServiceImp(InstitutoRepository institutoRepository) {
        this.institutoRepository = institutoRepository;
    }

    @Override
    public List<InstitutoDTO> getAll() {
        return institutoRepository.findAll().stream()
                .map(InstitutoAdapter::toDTO)
                .toList();
    }

    @Override
    public List<InstitutoDTO> getAllByUbicacion(String ubicacion) {
        List<InstitutoDTO> institutos = institutoRepository.findByUbicacionContainingIgnoreCase(ubicacion).stream()
                .map(InstitutoAdapter::toDTO)
                .toList();
        if(institutos.isEmpty()) throw new BusinessInstitutoException(String.format("No hay institutos con ubicación en %s", ubicacion));
        return institutos;
    }

    @Override
    public InstitutoResumenDTO getByNombreUbicacion(String nombre, String ubicacion) {
        return InstitutoAdapter.toResumenDTO(institutoRepository.findByNombreIgnoreCaseAndUbicacionIgnoreCase(nombre,ubicacion));
    }

    @Override
    public InstitutoResumenDTO getById(int id) {
        return InstitutoAdapter.toResumenDTO(institutoRepository.findById(id)
                .orElseThrow(() -> new BusinessInstitutoException("Elinstituto con ID " + id + " no se ha encontrado.")));
    }

    @Override
    public InstitutoDTO createInstituto(InstitutoDTO instituto) {
        Instituto nuevoInstituto = institutoRepository.findByNombreIgnoreCaseAndUbicacionIgnoreCase(instituto.getNombre(), instituto.getUbicacion());
        if(nuevoInstituto != null) throw new BusinessInstitutoException(String.format("El instituto %s, %s ya existe.",
                instituto.getNombre(), instituto.getUbicacion()));
        nuevoInstituto = new Instituto(instituto.getNombre(), instituto.getUbicacion());
        institutoRepository.save(nuevoInstituto);
        return instituto;
    }

    @Override
    public InstitutoDTO updateInstituo(int id, InstitutoDTO instituto) {
        Instituto institutoActualizar = institutoRepository.findById(id)
                .orElseThrow(() -> new BusinessInstitutoException("El instituto con ID " + id + " no existe."));
        Instituto institutoExiste = institutoRepository.findByNombreIgnoreCaseAndUbicacionIgnoreCase(instituto.getNombre(), instituto.getUbicacion());
        if(institutoExiste != null) throw new BusinessInstitutoException("Ya existe un instituto con el mismo nombre y ubicación.");
        institutoActualizar.setNombre(instituto.getNombre());
        institutoActualizar.setUbicacion(instituto.getUbicacion());
        institutoRepository.save(institutoActualizar);
        return instituto;
    }

    @Override
    public InstitutoResumenDTO deleteInstituoById(int id) {
        Instituto instituto = institutoRepository.findById(id)
                .orElseThrow(() -> new BusinessInstitutoException("Elinstituto con ID " + id + " no se ha encontrado."));
        institutoRepository.deleteById(id);
        return InstitutoAdapter.toResumenDTO(instituto);
    }
}
