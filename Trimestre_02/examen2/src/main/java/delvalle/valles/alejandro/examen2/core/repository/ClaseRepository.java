package delvalle.valles.alejandro.examen2.core.repository;

import delvalle.valles.alejandro.examen2.core.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    List<Clase> findByProfesorIgnoreCase(String profesor);
}
