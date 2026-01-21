package com.alejandro.delvalle.valles.pracaticaexamen.core.service.interfaces;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CrearCarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.enums.Colores;

import java.util.List;

public interface CarnetService {

    List<CarnetDTO> getAll();
    List<CarnetDTO> getByColor(Colores color);
    CarnetDTO getByAlumnoId(int id);
    CarnetDTO createCarnet(CrearCarnetDTO crearCarnet, int id);
    CarnetDTO updateCarnet(Colores color, int id);
    CarnetDTO deleteCarnet(int id);
}
