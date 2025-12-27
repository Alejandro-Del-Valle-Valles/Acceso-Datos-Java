package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.VaritaRepository;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.VaritaService;
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

    @Override
    public List<Varita> findByRota(boolean rota) {
        return varitaRepository.findByRota(rota);
    }

    @Override
    public List<Varita> findByNucleoContainingIgnoreCase(String nucleo) {
        return varitaRepository.findByNucleoContainingIgnoreCase(nucleo);
    }

    /**
     * Return a list of Varitas ordered form largest to sortest Longitud
     *
     * @return List<Varita>
     */
    @Override
    public List<Varita> findAllByOrderByLongitudDesc() {
        return varitaRepository.findAllByOrderByLongitudDesc();
    }

    /**
     * Return a list of Varitas ordered form sortest to largest Longitud
     *
     * @return List<Varita>
     */
    @Override
    public List<Varita> findAllByOrderByLongitudAsc() {
        return varitaRepository.findAllByOrderByLongitudAsc();
    }

    /**
     * Return a list of Varitas that are assigned to a Personaje
     *
     * @return List<Varita>
     */
    @Override
    public List<Varita> findByPersonajeNotNull() {
        return varitaRepository.findByPersonajeNotNull();
    }

    /**
     * Return a list of Varitas ordered Desc and they are attached to a Personaje.
     *
     * @return List<Varita>
     */
    @Override
    public List<Varita> findByPersonajeNotNullOrderByLongitudDesc() {
        return varitaRepository.findByPersonajeNotNullOrderByLongitudDesc();
    }

    /**
     * Return a list of Varitas ordered Asc and they are attached to a Personaje.
     *
     * @return List<Varita>
     */
    @Override
    public List<Varita> findByPersonajeNotNullOrderByLongitudAsc() {
        return varitaRepository.findByPersonajeNotNullOrderByLongitudAsc();
    }

    /**
     * Return a list of Varitas ordered Asc or Desc and if they are attached to a Personaje or not.
     *
     * @param desc             True to order from largest to sortest longitud, false otherwise.
     * @param personajeNotNull True to filter only if Personaje is not null, false otherwise.
     * @return List<Varita>
     */
    @Override
    public List<Varita> findWithFilter(boolean desc, boolean personajeNotNull) {
        List<Varita> varitas = null;
        if(personajeNotNull) varitas = desc
                ? findByPersonajeNotNullOrderByLongitudDesc()
                : findByPersonajeNotNullOrderByLongitudAsc();
        else varitas = desc
                ? findAllByOrderByLongitudDesc()
                : findAllByOrderByLongitudAsc();
        return varitas;
    }
}
