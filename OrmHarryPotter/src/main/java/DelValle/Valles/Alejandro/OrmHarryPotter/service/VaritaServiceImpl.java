package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.VaritaRepository;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.VaritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaritaServiceImpl implements VaritaService {

    private final VaritaRepository varitaRepository;

    @Autowired
    public VaritaServiceImpl(VaritaRepository varitaRepository) {
        this.varitaRepository = varitaRepository;
    }

    /**
     * Find all Varitas from the repository
     * @return List<Varita>
     */
    @Override
    public List<Varita> findAll() {
        return varitaRepository.findAll();
    }

    /**
     * Find a specific Varita from the repository by his ID
     * @param id int
     * @return Varita or null if not exists
     */
    @Override
    public Varita findById(int id) {
        return varitaRepository.findById(id);
    }

    /**
     * Save or update a Varita into the repository
     * @param varita Varita to update or save
     */
    @Override
    public void save(Varita varita) {
        varitaRepository.save(varita);
    }

    /**
     * Delete a Varita from the repository if exists
     * @param varita Varita to delete
     */
    @Override
    public void delete(Varita varita) {
        varitaRepository.delete(varita);
    }

    /**
     * Return all varitas from a Character.
     * @param personaje Personaje to find his Varitas
     * @return List<Varita>
     */
    @Override
    public List<Varita> findByPersonaje(Personaje personaje) {
        return varitaRepository.findByPersonaje(personaje);
    }
}
