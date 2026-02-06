package DelValle.Valles.Alejandro.OrmHarryPotter.interfaces;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;

import java.util.List;

public interface PersonajeService {

    public List<Personaje> findAll();
    public Personaje findById(int id);
    public void save(Personaje personaje);
    public void delete(Personaje personaje);
    public List<Personaje> findByNombreContainingIgnoreCase(String nombre);
    public List<Personaje> findByCasaNombre(String casa);
}
