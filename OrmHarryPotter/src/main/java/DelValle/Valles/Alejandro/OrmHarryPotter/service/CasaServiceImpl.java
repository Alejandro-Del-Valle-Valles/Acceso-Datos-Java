package DelValle.Valles.Alejandro.OrmHarryPotter.service;

import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.CasaService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl implements CasaService {

    private final CasaRepository casaRepository;

    @Autowired
    public CasaServiceImpl(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    @Override
    public List<Casa> findAll() {
        return casaRepository.findAll();
    }

    @Override
    public Casa findById(int id) {
        return casaRepository.findById(id);
    }

    @Override
    public Casa findByName(String name) {
        return casaRepository.findByNombre(name);
    }

    @Override
    public Casa findByFundador(String fundador) {
        return casaRepository.findByFundador(fundador);
    }

    @Override
    public void save(Casa casa) {
        casaRepository.save(casa);
    }

    @Override
    public void delete(Casa casa) {
        casaRepository.delete(casa);
    }
}
