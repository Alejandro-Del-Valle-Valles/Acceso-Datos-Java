package DelValle.Valles.Alejandro.OrmHarryPotter.interfaces;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;

import java.util.List;

public interface HechizoService {

    public List<Hechizo> findAll();
    public Hechizo findById(long id);
    public List<Hechizo> findByNombre(String nombre);
    public List<Hechizo> findByNombreContainingIgnoreCase(String nombre);
    public List<Hechizo> findByTipo(String tipo);
    public List<Hechizo> findByTipoContainingIgnoreCase(String tipo);
    public void save(Hechizo hechizo);
    public void delete(Hechizo hechizo);
}
