package delvalle.valles.alejandro.examen2.core.repository;

import delvalle.valles.alejandro.examen2.core.entity.Carnet;
import delvalle.valles.alejandro.examen2.core.enums.TipoSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Integer> {

    List<Carnet> findBySuscripcion(TipoSuscripcion suscripcion);
}
