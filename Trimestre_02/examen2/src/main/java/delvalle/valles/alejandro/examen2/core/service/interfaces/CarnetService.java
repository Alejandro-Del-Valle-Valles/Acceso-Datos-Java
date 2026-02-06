package delvalle.valles.alejandro.examen2.core.service.interfaces;

import delvalle.valles.alejandro.examen2.core.dto.CarnetDTO;
import delvalle.valles.alejandro.examen2.core.enums.TipoSuscripcion;

import java.util.List;

public interface CarnetService {

    CarnetDTO getById(int id);
    List<CarnetDTO> getAll();
    List<CarnetDTO> getBySuscripcion(TipoSuscripcion suscripcion);
    CarnetDTO createCarnet(CarnetDTO carnet);
    CarnetDTO updateCarnet(CarnetDTO carnet);
    CarnetDTO deleteCarnet(int id);
}
