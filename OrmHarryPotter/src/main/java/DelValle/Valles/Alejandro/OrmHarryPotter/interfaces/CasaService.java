package DelValle.Valles.Alejandro.OrmHarryPotter.interfaces;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;

import java.util.List;

public interface CasaService {

    public List<Casa> findAll();
    public Casa findById(int id);
    public Casa findByName(String name);
    public Casa findByFundador(String fundador);
    public  void save(Casa casa);
    public void delete(Casa casa);
}
