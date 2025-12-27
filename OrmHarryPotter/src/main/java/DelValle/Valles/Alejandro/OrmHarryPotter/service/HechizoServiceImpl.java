package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.HechizoService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.HechizoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Page<Hechizo> findAll(Pageable pageable, String order) {
        Sort sort = Sort.unsorted();
        if(order != null) {
            if(order.equals("asc")) {
                sort = Sort.by(Sort.Direction.ASC, "nombre");
            } else if (order.equals("desc")) {
                sort = Sort.by(Sort.Direction.DESC, "nombre");
            }
        }
        Pageable forcedPageable = PageRequest.of(
                pageable.getPageNumber(),
                5,
                sort
        );
        return hechizoRepository.findAll(forcedPageable);
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
