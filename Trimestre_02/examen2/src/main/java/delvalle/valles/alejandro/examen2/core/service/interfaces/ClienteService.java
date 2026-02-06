package delvalle.valles.alejandro.examen2.core.service.interfaces;

import delvalle.valles.alejandro.examen2.core.dto.ClienteDTO;
import delvalle.valles.alejandro.examen2.core.dto.ClienteResumenDTO;
import delvalle.valles.alejandro.examen2.core.dto.CrearClienteCarnetDTO;
import delvalle.valles.alejandro.examen2.core.dto.CrearClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    ClienteResumenDTO getByCarnetId(int id);
    List<ClienteDTO> getAll();
    List<ClienteDTO> getByClaseId(int id);
    List<ClienteDTO> getByNombreContains(String nombre);
    List<ClienteDTO> getOrderByFechaNacimiento(boolean asc);
    ClienteResumenDTO createClienteCarnet(CrearClienteCarnetDTO cliente);
    ClienteDTO createCliente(CrearClienteDTO cliente);
    ClienteResumenDTO updateCliente(CrearClienteDTO cliente);
    ClienteResumenDTO deleteCliente(UUID id);
}
