package com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.instituto.InstitutoResumenDTO;

import java.util.List;

public interface InstitutoService {

    List<InstitutoDTO> getAll();
    List<InstitutoDTO> getAllByUbicacion(String ubicacion);
    InstitutoResumenDTO getByNombreUbicacion(String nombre, String ubicacion);
    InstitutoResumenDTO getById(int id);
    InstitutoDTO createInstituto(InstitutoDTO instituto);
    InstitutoDTO updateInstituo(int id, InstitutoDTO instituto);
    InstitutoResumenDTO deleteInstituoById(int id);
}
