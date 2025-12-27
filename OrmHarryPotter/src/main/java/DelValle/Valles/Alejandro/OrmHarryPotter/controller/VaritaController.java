package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearVaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaResumenDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaAlreadyExistException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaNotCreatedUpdatedException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaNotFoundException;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.VaritaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/varita")
public class VaritaController {

    private final VaritaService varitaService;

    @Autowired
    public VaritaController(VaritaService varitaService) {
        this.varitaService = varitaService;
    }

    @GetMapping
    public ResponseEntity<List<VaritaDTO>> getAllVaritas() {
        List<VaritaDTO> varitas = varitaService.findAll().stream()
                .map(this::createVaritaDTO)
                .toList();
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/rota")
    public ResponseEntity<List<VaritaDTO>> getAllRotas(@RequestParam boolean rotas) {
        List<VaritaDTO> varitas = varitaService.findByRota(rotas).stream()
                .map(this::createVaritaDTO)
                .toList();
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/nucleo/{nucleo}")
    public ResponseEntity<List<VaritaDTO>> getVaritasByNucleo(@PathVariable String nucleo) {
        List<VaritaDTO> varitas = varitaService.findByNucleoContainingIgnoreCase(nucleo).stream()
                .map(this::createVaritaDTO)
                .toList();
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<VaritaResumenDTO>> getResumenVaritas() {
        List<VaritaResumenDTO> varitas = varitaService.findAll().stream()
                .map(this::createVaritaResumenDTO)
                .toList();
        return ResponseEntity.ok(varitas);
    }

    @PutMapping("rota/{id}")
    public ResponseEntity<?> putVaritaRota(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varita.setRota(true);
            varitaService.save(varita);
            return ResponseEntity.ok(createVaritaResumenDTO(varita));
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Varita con id %d no encontrada", id));
    }

    @PostMapping
    public ResponseEntity<CrearVaritaDTO> postVaritaMadera(@Valid @RequestBody CrearVaritaDTO varita) {
        Varita newVarita = new Varita(varita.getLongitud(), varita.getMadera(), varita.getNucleo(),
                false, null);
        if(varitaService.findById(newVarita.getId()) == null) {
            varitaService.save(newVarita);
            Varita insertedVarita = varitaService.findById(newVarita.getId());
            if (insertedVarita != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(varita);
            } else throw new VaritaNotCreatedUpdatedException();
        } else throw new VaritaAlreadyExistException();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<VaritaResumenDTO> deleteVarita(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varitaService.delete(varita);
            return ResponseEntity.status(HttpStatus.OK).body(createVaritaResumenDTO(varita));
        } else throw new VaritaNotFoundException(id);
    }

    @GetMapping("/ordenadas")
    public ResponseEntity<List<VaritaDTO>> getOrdenadas(
        @RequestParam(required = false, defaultValue = "false") boolean descendente,
        @RequestParam(required = false, defaultValue = "false") boolean solamenteUsadas
    ) {
        List<VaritaDTO> varitas = varitaService.findWithFilter(descendente, solamenteUsadas).stream()
                .map(this::createVaritaDTO)
                .toList();
        return varitas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(varitas);
    }

    private VaritaDTO createVaritaDTO(Varita varita) {
        Personaje personaje = varita.getPersonaje();
        return new VaritaDTO(varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                varita.isRota(), personaje == null ? null : personaje.getId(),
                personaje == null ? null : personaje.getNombre());
    }

    private VaritaResumenDTO createVaritaResumenDTO(Varita varita) {
        Personaje personaje = varita.getPersonaje();
        return new VaritaResumenDTO(
                varita.getId(), String.format("%s. %s", varita.getMadera(), varita.getNucleo()),
                varita.getLongitud(), varita.isRota(),
                personaje == null ? null : personaje.getNombre()
        );
    }
}
