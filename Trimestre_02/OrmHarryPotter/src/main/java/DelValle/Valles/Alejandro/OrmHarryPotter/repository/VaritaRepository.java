package DelValle.Valles.Alejandro.OrmHarryPotter.repository;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaritaRepository extends JpaRepository<Varita, Long> {

    public List<Varita> findByPersonaje(Personaje personaje);
    public Varita findById(int id);
    public List<Varita> findByRota(boolean rota);
    public List<Varita> findByNucleoContainingIgnoreCase(String nucleo);
    public List<Varita> findAllByOrderByLongitudDesc();
    public List<Varita> findAllByOrderByLongitudAsc();
    public List<Varita> findByPersonajeNotNull();
    public List<Varita> findByPersonajeNotNullOrderByLongitudDesc();
    public List<Varita> findByPersonajeNotNullOrderByLongitudAsc();
}
