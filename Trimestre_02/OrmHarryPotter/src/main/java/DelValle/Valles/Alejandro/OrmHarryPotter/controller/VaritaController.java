package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.adpater.VaritaAdapter;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearVaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaMovilesDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaResumenDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaNotCreatedUpdatedException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaNotFoundException;
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
@CrossOrigin(origins = "*")
public class VaritaController {

    private final VaritaService varitaService;

    @Autowired
    public VaritaController(VaritaService varitaService) {
        this.varitaService = varitaService;
    }

    @GetMapping
    public ResponseEntity<List<VaritaDTO>> getAllVaritas() {
        List<VaritaDTO> varitas = VaritaAdapter.toDTO(varitaService.findAll());
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/moviles")
    public ResponseEntity<List<VaritaMovilesDTO>> getAllVaritasMoviles() {
        List<VaritaMovilesDTO> varitas = VaritaAdapter.toMovilesDTO(varitaService.findAll());
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/rota")
    public ResponseEntity<List<VaritaDTO>> getAllRotas(@RequestParam boolean rotas) {
        List<VaritaDTO> varitas = VaritaAdapter.toDTO(varitaService.findByRota(rotas));
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/nucleo/{nucleo}")
    public ResponseEntity<List<VaritaDTO>> getVaritasByNucleo(@PathVariable String nucleo) {
        List<VaritaDTO> varitas = VaritaAdapter.toDTO(varitaService.findByNucleoContainingIgnoreCase(nucleo));
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<VaritaResumenDTO>> getResumenVaritas() {
        List<VaritaResumenDTO> varitas = VaritaAdapter.toResumenDTO(varitaService.findAll());
        return ResponseEntity.ok(varitas);
    }

    @PutMapping("rota/{id}")
    public ResponseEntity<?> putVaritaRota(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varita.setRota(true);
            varitaService.save(varita);
            return ResponseEntity.ok(VaritaAdapter.toResumenDTO(varita));
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Varita con id %d no encontrada", id));
    }

    @PostMapping
    public ResponseEntity<CrearVaritaDTO> postVaritaMadera(@Valid @RequestBody CrearVaritaDTO varita) {
        Varita newVarita = new Varita(varita.getLongitud(), varita.getMadera(), varita.getNucleo(),
                false, null);
        varitaService.save(newVarita);
        Varita insertedVarita = varitaService.findById(newVarita.getId());
        if (insertedVarita != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(varita);
        } else throw new VaritaNotCreatedUpdatedException();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<VaritaResumenDTO> deleteVarita(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varitaService.delete(varita);
            return ResponseEntity.status(HttpStatus.OK).body(VaritaAdapter.toResumenDTO(varita));
        } else throw new VaritaNotFoundException(id);
    }

    @GetMapping("/ordenadas")
    public ResponseEntity<List<VaritaDTO>> getOrdenadas(
        @RequestParam(required = false, defaultValue = "false") boolean descendente,
        @RequestParam(required = false, defaultValue = "false") boolean solamenteUsadas
    ) {
        List<VaritaDTO> varitas = VaritaAdapter.toDTO(varitaService.findWithFilter(descendente, solamenteUsadas));
        return varitas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(varitas);
    }


}
