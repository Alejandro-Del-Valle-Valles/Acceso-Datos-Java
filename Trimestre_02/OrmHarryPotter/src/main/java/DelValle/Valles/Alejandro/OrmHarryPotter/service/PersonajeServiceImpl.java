package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.PersonajeService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<Personaje> findAll() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje findById(int id) {
        return personajeRepository.findById(id);
    }

    @Override
    public void save(Personaje personaje) {
        personajeRepository.save(personaje);
    }

    @Override
    public void delete(Personaje personaje) {
        personajeRepository.delete(personaje);
    }

    @Override
    public List<Personaje> findByNombreContainingIgnoreCase(String nombre) {
        return personajeRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Personaje> findByCasaNombre(String casa) {
        return personajeRepository.findByCasaNombre(casa);
    }
}
