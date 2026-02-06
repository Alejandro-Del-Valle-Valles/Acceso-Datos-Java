package DelValle.Valles.Alejandro.OrmHarryPotter.repository;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepository extends JpaRepository<Casa, Integer> {

    public Casa findById(int id);
    public Casa findByNombre(String nombre);
    public Casa findByFundador(String fundador);
}
