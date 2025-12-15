package DelValle.Valles.Alejandro.OrmHarryPotter.repository;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;

import java.util.List;

public interface VaritaService {

    /**
     * Find all Varitas from the repository
     * @return List<Varita>
     */
    public List<Varita> findAll();

    /**
     * Find a specific Varita from the repository by his ID
     * @param id int
     * @return Varita or null if not exists
     */
    public Varita findById(int id);

    /**
     * Save or update a Varita into the repository
     * @param varita Varita to update or save
     */
    public void save(Varita varita);

    /**
     * Delete a Varita from the repository if exists
     * @param varita Varita to delete
     */
    public void delete(Varita varita);

    /**
     * Return all varitas from a Character.
     * @param personaje Personaje to find his Varitas
     * @return List<Varita>
     */
    public List<Varita> findByPersonaje(Personaje personaje);
}
