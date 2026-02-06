package delvalle.valles.alejandro.examen2.adapter;

import delvalle.valles.alejandro.examen2.core.dto.ClienteDTO;
import delvalle.valles.alejandro.examen2.core.entity.Carnet;
import delvalle.valles.alejandro.examen2.core.entity.Cliente;

public class ClienteAdapter {

    public static ClienteDTO toDTO(Cliente cliente) {
        Carnet carnet = cliente.getCarnet();
        return new ClienteDTO(cliente.getNombre(), cliente.getFechaNacimiento(),
                carnet != null ? carnet.getId() : null);
    }
}
