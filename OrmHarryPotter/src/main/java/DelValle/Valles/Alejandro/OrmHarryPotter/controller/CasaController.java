package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CasaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.CasaNotFoundException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.IdNotValidException;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.CasaService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaService casaService;

    @Autowired
    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @GetMapping
    public ResponseEntity<List<CasaDTO>> getCasas(){
        List<CasaDTO> casas = casaService.findAll().stream()
                .map(this::createCasaDTO)
                .toList();
        return ResponseEntity.ok(casas);
    }

    @GetMapping("/especifica")
    public ResponseEntity<CasaDTO> getCasaById(@RequestParam Integer id){
        if(id != null && id > 0) {
            Casa casa = casaService.findById(id);
            if(casa != null) {
                return ResponseEntity.ok(this.createCasaDTO(casa));
            } else throw new CasaNotFoundException();
        } else throw new IdNotValidException(id);
    }

    private CasaDTO createCasaDTO(Casa casa){
        String fullImageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/img/escudos/")
                .path(casa.getEscudo_imagen())
                .toUriString();
        List<String> personajes = casa.getPersonajes().stream()
                .map(Personaje::getNombre)
                .toList();
        return new CasaDTO(casa.getNombre(), casa.getFundador(), fullImageUrl, personajes);
    }
}
