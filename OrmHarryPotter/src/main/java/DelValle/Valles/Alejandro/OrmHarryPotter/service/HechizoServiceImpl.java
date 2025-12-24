package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.HechizoService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.HechizoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HechizoServiceImpl implements HechizoService {

    private final HechizoRepository hechizoRepository;

    @Autowired
    public HechizoServiceImpl(HechizoRepository hechizoRepository) {
        this.hechizoRepository = hechizoRepository;
    }

    @Override
    public List<Hechizo> findAll() {
        return hechizoRepository.findAll();
    }

    @Override
    public Hechizo findById(long id) {
        return hechizoRepository.findById(id);
    }

    @Override
    public List<Hechizo> findByNombre(String nombre) {
        return hechizoRepository.findByNombre(nombre);
    }

    @Override
    public List<Hechizo> findByNombreContainingIgnoreCase(String nombre) {
        return hechizoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Hechizo> findByTipo(String tipo) {
        return hechizoRepository.findByTipo(tipo);
    }

    @Override
    public List<Hechizo> findByTipoContainingIgnoreCase(String tipo) {
        return hechizoRepository.findByTipoContainingIgnoreCase(tipo);
    }

    @Override
    public void save(Hechizo hechizo) {
        hechizoRepository.save(hechizo);
    }

    @Override
    public void delete(Hechizo hechizo) {
        hechizoRepository.delete(hechizo);
    }
}
