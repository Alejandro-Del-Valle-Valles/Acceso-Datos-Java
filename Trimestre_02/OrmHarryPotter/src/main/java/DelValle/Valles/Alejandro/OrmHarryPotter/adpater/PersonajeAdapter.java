package DelValle.Valles.Alejandro.OrmHarryPotter.adpater;

import DelValle.Valles.Alejandro.OrmHarryPotter.dto.PersonajeDTO;
import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;

public class PersonajeAdapter {

    public static PersonajeDTO toDTO(Personaje personaje) {
        return new PersonajeDTO(personaje.getId(), personaje.getNombre(), personaje.getFechaNacimiento(),
                personaje.getSangre(), personaje.getCasa().getNombre());
    }
}
