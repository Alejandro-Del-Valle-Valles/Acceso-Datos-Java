package delvalle.valles.alejandro.examen2.core.service;

import delvalle.valles.alejandro.examen2.adapter.ClienteAdapter;
import delvalle.valles.alejandro.examen2.core.dto.ClienteDTO;
import delvalle.valles.alejandro.examen2.core.dto.ClienteResumenDTO;
import delvalle.valles.alejandro.examen2.core.dto.CrearClienteCarnetDTO;
import delvalle.valles.alejandro.examen2.core.dto.CrearClienteDTO;
import delvalle.valles.alejandro.examen2.core.repository.CarnetRepository;
import delvalle.valles.alejandro.examen2.core.repository.ClaseRepository;
import delvalle.valles.alejandro.examen2.core.repository.ClienteRepository;
import delvalle.valles.alejandro.examen2.core.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final CarnetRepository carnetRepository;
    private final ClaseRepository claseRepository;

    @Autowired

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              CarnetRepository carnetRepository, ClaseRepository claseRepository) {
        this.clienteRepository = clienteRepository;
        this.carnetRepository = carnetRepository;
        this.claseRepository = claseRepository;
    }


    @Override
    public ClienteResumenDTO getByCarnetId(int id) {
        return null;
    }

    @Override
    public List<ClienteDTO> getAll() {
        return clienteRepository.findAll().stream()
                .map(ClienteAdapter::toDTO)
                .toList();
    }

    @Override
    public List<ClienteDTO> getByClaseId(int id) {
        return List.of();
    }

    @Override
    public List<ClienteDTO> getByNombreContains(String nombre) {
        return List.of();
    }

    @Override
    public List<ClienteDTO> getOrderByFechaNacimiento(boolean asc) {
        return List.of();
    }

    @Override
    public ClienteResumenDTO createClienteCarnet(CrearClienteCarnetDTO cliente) {
        return null;
    }

    @Override
    public ClienteDTO createCliente(CrearClienteDTO cliente) {
        return null;
    }

    @Override
    public ClienteResumenDTO updateCliente(CrearClienteDTO cliente) {
        return null;
    }

    @Override
    public ClienteResumenDTO deleteCliente(UUID id) {
        return null;
    }
}
