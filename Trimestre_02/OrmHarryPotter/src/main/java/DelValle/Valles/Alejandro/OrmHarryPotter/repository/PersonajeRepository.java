package DelValle.Valles.Alejandro.OrmHarryPotter.repository;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {

    public Personaje findById(int id);
    public List<Personaje> findByNombreContainingIgnoreCase(String nombre);
    public List<Personaje> findByCasaNombre(String casa);
}
