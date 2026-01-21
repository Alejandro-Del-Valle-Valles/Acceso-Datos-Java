package com.alejandro.delvalle.valles.pracaticaexamen.adapter;

import com.alejandro.delvalle.valles.pracaticaexamen.core.dto.carnet.CarnetDTO;
import com.alejandro.delvalle.valles.pracaticaexamen.core.entity.Carnet;

public class CarnetAdpater {

    public static CarnetDTO toDTO(Carnet carnet) {
        return new CarnetDTO(carnet.getColor(), AlumnoAdapter.toDTO(carnet.getAlumno()));
    }
}
