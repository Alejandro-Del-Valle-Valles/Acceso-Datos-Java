package DelValle.Valles.Alejandro.OrmHarryPotter.repository;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HechizoRepository extends JpaRepository<Hechizo, Long> {

    public Hechizo findById(long id);
    public List<Hechizo> findByNombre(String nombre);
    public List<Hechizo> findByNombreContainingIgnoreCase(String nombre);
    public List<Hechizo> findByTipo(String tipo);
    public List<Hechizo> findByTipoContainingIgnoreCase(String tipo);
}
