package DelValle.Valles.Alejandro.OrmHarryPotter.controller;

import DelValle.Valles.Alejandro.OrmHarryPotter.adpater.PersonajeAdapter;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearPersonajeVaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearVaritaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.PersonajeDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CrearPersonajeDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.CasaNotFoundException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.PersonajeNotCreatedUpdatedException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.PersonajeNotFoundException;
import DelValle.Valles.Alejandro.OrmHarryPotter.exceptions.VaritaNotFoundException;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.CasaService;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.PersonajeService;
import DelValle.Valles.Alejandro.OrmHarryPotter.interfaces.VaritaService;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Hechizo;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    private final PersonajeService personajeService;
    private final CasaService casaService;
    private final VaritaService varitaService;

    @Autowired
    public PersonajeController(PersonajeService personajeService, CasaService casaService, VaritaService varitaService) {
        this.personajeService = personajeService;
        this.casaService = casaService;
        this.varitaService = varitaService;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> findAll() {
        List<PersonajeDTO> personajes = personajeService.findAll().stream()
                .map(PersonajeAdapter::toDTO)
                .toList();
        return ResponseEntity.ok().body(personajes);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@Valid @RequestBody CrearPersonajeDTO personaje) {
        Casa casa = casaService.findByName(personaje.getNombreCasa());
        Personaje newPersonaje = new Personaje(
                personaje.getFechaNacimiento(), personaje.getNombre(), personaje.getSangre(),
                casa, null, new ArrayList<Hechizo>());
        if(personajeService.findById(newPersonaje.getId()) != null) {
            personajeService.save(newPersonaje);
            PersonajeDTO personajeDTO = PersonajeAdapter.toDTO(newPersonaje);
            return ResponseEntity.status(HttpStatus.CREATED).body(personajeDTO);
        } else throw new PersonajeNotCreatedUpdatedException();
    }

    @GetMapping("/nombre/{palabra}")
    public ResponseEntity<List<PersonajeDTO>> containsInName(@PathVariable String palabra) {
        List<PersonajeDTO> personajes = personajeService.findByNombreContainingIgnoreCase(palabra).stream()
                .map(PersonajeAdapter::toDTO)
                .toList();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/casa/{nombreCasa}")
    public ResponseEntity<List<PersonajeDTO>> areFromHouse(@PathVariable String nombreCasa) {
        List<PersonajeDTO> personajes = personajeService.findByCasaNombre(nombreCasa).stream()
                .map(PersonajeAdapter::toDTO)
                .toList();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Personaje personaje = personajeService.findById(id);
        if(personaje != null) {
            return ResponseEntity.ok().body(PersonajeAdapter.toDTO(personaje));
        } else throw new PersonajeNotFoundException(id);
    }

    @PutMapping("/{idPersonaje}/varita/{idVarita}")
    public ResponseEntity<?> updatePersonajeVarita(@PathVariable Integer idPersonaje, @PathVariable Integer idVarita) {
        Personaje personaje = personajeService.findById(idPersonaje);
        Varita nuevaVarita = varitaService.findById(idVarita);

        if (personaje == null) throw new PersonajeNotFoundException(idPersonaje);
        if (nuevaVarita == null) throw new VaritaNotFoundException(idVarita);
        if (nuevaVarita.isRota()) return ResponseEntity.status(HttpStatus.CONFLICT).body("La varita está rota.");

        if (personaje.getVarita() != null) {
            personaje.addVarita(nuevaVarita);
        }
        personajeService.save(personaje);
        return ResponseEntity.ok(PersonajeAdapter.toDTO(personaje));
    }

    @PostMapping("/crear-con-varita")
    @Transactional
    public ResponseEntity<CrearPersonajeVaritaDTO> createPersonajeWithVarita(@Valid @RequestBody CrearPersonajeVaritaDTO personaje) {
        CrearVaritaDTO varitaDTO = personaje.getCrearVaritaDTO();
        Casa casa = casaService.findByName(personaje.getNombreCasa());
        if(casa == null) throw new CasaNotFoundException(personaje.getNombreCasa());
        Personaje newPersonaje = new Personaje(personaje.getFechaNacimiento(), personaje.getNombre(),
                personaje.getSangre(), casa, null, new ArrayList<>());
        Varita nuevaVarita = new Varita(varitaDTO.getLongitud(), varitaDTO.getMadera(),
                varitaDTO.getNucleo(), false, newPersonaje);
        newPersonaje.addVarita(nuevaVarita);
        personajeService.save(newPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaje);
    }
}
