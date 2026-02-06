package DelValle.Valles.Alejandro.OrmHarryPotter.interfaces;

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

    /**
     * Return a list of Varitas if they are broken or not.
     * @param rota true if want to get the broken varitas, false otherwise.
     * @return List<Varita>
     */
    public List<Varita> findByRota(boolean rota);

    /**
     * Return a list of Varitas if the nucelo contains the inserted text
     * @param nucleo String searched nucleo
     * @return List<Varita>
     */
    public  List<Varita> findByNucleoContainingIgnoreCase(String nucleo);

    /**
     * Return a list of Varitas ordered form largest to sortest Longitud
     * @return List<Varita>
     */
    public List<Varita> findAllByOrderByLongitudDesc();

    /**
     * Return a list of Varitas ordered form sortest to largest Longitud
     * @return List<Varita>
     */
    public List<Varita> findAllByOrderByLongitudAsc();

    /**
     * Return a list of Varitas that are assigned to a Personaje
     * @return List<Varita>
     */
    public List<Varita> findByPersonajeNotNull();

    /**
     * Return a list of Varitas ordered Desc and they are attached to a Personaje.
     * @return List<Varita>
     */
    public List<Varita> findByPersonajeNotNullOrderByLongitudDesc();

    /**
     * Return a list of Varitas ordered Asc and they are attached to a Personaje.
     * @return List<Varita>
     */
    public List<Varita> findByPersonajeNotNullOrderByLongitudAsc();

    /**
     * Return a list of Varitas ordered Asc or Desc and if they are attached to a Personaje or not.
     * @param desc True to order from largest to sortest longitud, false otherwise.
     * @param personajeNotNull  True to filter only if Personaje is not null, false otherwise.
     * @return List<Varita>
     */
    public List<Varita> findWithFilter(boolean desc, boolean personajeNotNull);
}
