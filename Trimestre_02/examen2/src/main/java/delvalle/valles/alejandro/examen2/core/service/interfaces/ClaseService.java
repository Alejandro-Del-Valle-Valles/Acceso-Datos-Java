package delvalle.valles.alejandro.examen2.core.service.interfaces;

import delvalle.valles.alejandro.examen2.core.dto.ClaseDTO;

import java.util.List;

public interface ClaseService {

    ClaseDTO getById(int id);
    List<ClaseDTO> getAll();
    List<ClaseDTO> getByProfesor(String profesor);
    ClaseDTO createClase(ClaseDTO clase);
    ClaseDTO updateClase(ClaseDTO clase);
    ClaseDTO deleteClase(ClaseDTO clase);
}
