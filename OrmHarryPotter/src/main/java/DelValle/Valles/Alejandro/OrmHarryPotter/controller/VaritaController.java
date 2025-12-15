package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.VaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.repository.VaritaService;
import DelValle.Valles.Alejandro.OrmHarryPotter.service.VaritaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                varita.isRota(), varita.getPersonaje().getId(), varita.getPersonaje().getNombre()
        )));
        return ResponseEntity.ok(varitas);
    }
}
