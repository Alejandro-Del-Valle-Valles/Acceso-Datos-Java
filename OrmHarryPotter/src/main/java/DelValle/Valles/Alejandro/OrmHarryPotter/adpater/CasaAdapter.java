package DelValle.Valles.Alejandro.OrmHarryPotter.adpater;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.CasaDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Casa;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

public class CasaAdapter {

    public static CasaDTO toDTO(Casa casa){
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
