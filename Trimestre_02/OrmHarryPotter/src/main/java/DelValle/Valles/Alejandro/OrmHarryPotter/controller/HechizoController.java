package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.adpater.HechizoAdapter;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearHechizoDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.HechizoDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.HechizoService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hechizo")
public class HechizoController {

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
        return ResponseEntity.ok(HechizoAdapter.toDTO(newHechizo));
    }

    @PostMapping("/crear-varios")
    public ResponseEntity<List<HechizoDTO>> postHechizos(@Valid @RequestBody List<CrearHechizoDTO> hechizos) {
        List<HechizoDTO> hechizosDTO = new ArrayList<>();
        hechizos.forEach(hechizo -> {
            Hechizo newHechizo = new Hechizo(hechizo.getDescripcion(), hechizo.getNombre(),
                    hechizo.getTipo().toString(), new ArrayList<>());
            hechizoService.save(newHechizo);
            hechizosDTO.add(HechizoAdapter.toDTO(newHechizo));
        });
        return ResponseEntity.ok(hechizosDTO);
    }

    @GetMapping("/paginacion")
    public ResponseEntity<Page<HechizoDTO>> getHechizosWithPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String order
    ) {
        Pageable pages = PageRequest.of(page, 5);
        Page<Hechizo> hechizoPage = hechizoService.findAll(pages, order);
        Page<HechizoDTO> hechizos = hechizoPage.map(HechizoAdapter::toDTO);
        return ResponseEntity.ok(hechizos);
    }
}
