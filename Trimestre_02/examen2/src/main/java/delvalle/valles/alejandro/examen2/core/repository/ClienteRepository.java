package delvalle.valles.alejandro.examen2.core.repository;

import delvalle.valles.alejandro.examen2.core.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    Cliente findByCarnetId(int id);
    List<Cliente> findByClaseId(int id);
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    List<Cliente> findByOrderByFechaNacimientoDesc();
    List<Cliente> findByOrderByFechaNacimientoAsc();
}
