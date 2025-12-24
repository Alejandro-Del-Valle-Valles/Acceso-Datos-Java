package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearHechizoDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.HechizoDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.HechizoService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hechizo")
public class HechizoController {

    //TODO: Testear este controller. También testear las nuevas excepciones y su manejo.
    // También los nuevos endpoints de PersonajeController
    private final HechizoService hechizoService;

    @Autowired
    public HechizoController(HechizoService hechizoService) {
        this.hechizoService = hechizoService;
    }

    @GetMapping
    public ResponseEntity<List<Hechizo>> getHechizos() {
        return ResponseEntity.ok(hechizoService.findAll());
    }

    @PostMapping
    public ResponseEntity<HechizoDTO> postHechizo(@Valid @RequestBody CrearHechizoDTO hechizo) {
        Hechizo newHechizo = new Hechizo(hechizo.getDescripcion(), hechizo.getNombre(),
                hechizo.getTipo().toString(), new ArrayList<>());
        hechizoService.save(newHechizo);
        return ResponseEntity.ok(createHechizoDTO(newHechizo));
    }

    @PostMapping("/crear-varios")
    public ResponseEntity<List<HechizoDTO>> postHechizos(@Valid @RequestBody List<CrearHechizoDTO> hechizos) {
        List<HechizoDTO> hechizosDTO = new ArrayList<>();
        hechizos.forEach(hechizo -> {
            Hechizo newHechizo = new Hechizo(hechizo.getDescripcion(), hechizo.getNombre(),
                    hechizo.getTipo().toString(), new ArrayList<>());
            hechizoService.save(newHechizo);
            hechizosDTO.add(createHechizoDTO(newHechizo));
        });
        return ResponseEntity.ok(hechizosDTO);
    }

    private HechizoDTO createHechizoDTO(Hechizo hechizo) {
        return new HechizoDTO(hechizo.getNombre(), hechizo.getDescripcion(), hechizo.getTipo());
    }
}
