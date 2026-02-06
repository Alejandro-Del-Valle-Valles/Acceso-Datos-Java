package com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.asignatura.AsignaturaResumenDTO;

import java.util.List;

public interface AsignaturaService {

    List<String> getAsignaturas();
    List<AsignaturaResumenDTO> getResumenAsignaturas();
    List<String> getByNombreContains(String nombre);
    AsignaturaResumenDTO getByNombre(String nombre);
    AsignaturaResumenDTO createAsignatura(String nombre);
    AsignaturaResumenDTO updateAsignatura(String nombreActual, String nuevoNombre);
    AsignaturaResumenDTO deleteAsignatura(String nombre);
}
