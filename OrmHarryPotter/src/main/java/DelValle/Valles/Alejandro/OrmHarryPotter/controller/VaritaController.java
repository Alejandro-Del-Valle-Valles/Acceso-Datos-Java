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
        List<VaritaDTO> varitas = new ArrayList<>();
        varitaService.findAll().forEach(varita -> varitas.add(new VaritaDTO(
                varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                varita.isRota(),
                varita.getPersonaje() == null ? null : varita.getPersonaje().getId(),
                varita.getPersonaje() == null ? null : varita.getPersonaje().getNombre()
        )));
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/rota")
    public ResponseEntity<List<VaritaDTO>> getAllRotas(@RequestParam boolean rotas) {
        List<VaritaDTO> varitas = new ArrayList<>();
        varitaService.findByRota(rotas).forEach(varita ->
                varitas.add(new VaritaDTO(
                        varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                        varita.isRota(),
                        varita.getPersonaje() == null ? null : varita.getPersonaje().getId(),
                        varita.getPersonaje() == null ? null : varita.getPersonaje().getNombre()
                )));
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/nucleo/{nucleo}")
    public ResponseEntity<List<VaritaDTO>> getVaritasByNucleo(@PathVariable String nucleo) {
        List<VaritaDTO> varitas = new ArrayList<>();
        varitaService.findByNucleoContainingIgnoreCase(nucleo).forEach(varita ->
                varitas.add(new VaritaDTO(
                        varita.getMadera(), varita.getNucleo(), varita.getLongitud(),
                        varita.isRota(),
                        varita.getPersonaje() == null ? null : varita.getPersonaje().getId(),
                        varita.getPersonaje() == null ? null : varita.getPersonaje().getNombre()
                ))
        );
        return ResponseEntity.ok(varitas);
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<VaritaResumenDTO>> getResumenVaritas() {
        List<VaritaResumenDTO> varitas = new ArrayList<>();
        varitaService.findAll().forEach(varita ->
                varitas.add(new VaritaResumenDTO(
                        varita.getId(), String.format("%s. %s", varita.getMadera(), varita.getNucleo()),
                        varita.getLongitud(), varita.isRota(),
                        varita.getPersonaje() == null ? null : varita.getPersonaje().getNombre()
                )));
        return ResponseEntity.ok(varitas);
    }

    @PutMapping("rota/{id}")
    public ResponseEntity<?> putVaritaRota(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varita.setRota(true);
            varitaService.save(varita);
            Personaje personaje = varita.getPersonaje();
            VaritaResumenDTO varitaDTO = new VaritaResumenDTO(
                    varita.getId(), String.format("%s. %s", varita.getMadera(), varita.getNucleo()),
                    varita.getLongitud(), varita.isRota(), personaje == null ? null : personaje.getNombre()
            );
            return ResponseEntity.ok(varitaDTO);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Varita con id %d no encontrada", id));
    }

    @PostMapping
    public ResponseEntity<?> postVaritaMadera(@Valid @RequestBody CrearVaritaDTO varita) {
        Varita newVarita = new Varita(varita.getLongitud(), varita.getMadera(), varita.getNucleo(),
                false, null);
        if(varitaService.findById(newVarita.getId()) == null) {
            varitaService.save(newVarita);
            Varita insertedVarita = varitaService.findById(newVarita.getId());
            if (insertedVarita != null) {
                Personaje insertedPersonaje = insertedVarita.getPersonaje();
                VaritaResumenDTO varitaDTO = new VaritaResumenDTO(
                        insertedVarita.getId(), String.format("%s. %s", insertedVarita.getMadera(), insertedVarita.getNucleo()),
                        insertedVarita.getLongitud(), insertedVarita.isRota(),
                        insertedPersonaje == null ? null : insertedPersonaje.getNombre()
                );
                return ResponseEntity.status(HttpStatus.CREATED).body(varitaDTO);
            } else throw new VaritaNotCreatedUpdatedException();
        } else throw new VaritaAlreadyExistException();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteVarita(@PathVariable int id) {
        Varita varita = varitaService.findById(id);
        if(varita != null) {
            varitaService.delete(varita);
            Personaje personaje = varita.getPersonaje();
            VaritaResumenDTO deleted = new VaritaResumenDTO(
                    varita.getId(), String.format("%s. %s", varita.getMadera(), varita.getNucleo()),
                    varita.getLongitud(), varita.isRota(),
                    personaje == null ? null : personaje.getNombre()
            );
            return  ResponseEntity.status(HttpStatus.OK).body(varita);
        } else throw new VaritaNotFoundException(id);
    }
}
