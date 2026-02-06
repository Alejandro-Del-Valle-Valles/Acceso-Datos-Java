package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;

public class PersonajeNotFoundException extends RuntimeException {

    public PersonajeNotFoundException() {
        super("El personaje buscado no existe.");
    }

    public PersonajeNotFoundException(Personaje personaje) {
        super("El personaje con ID: " + personaje.getId() + " no existe.");
    }

    public PersonajeNotFoundException(Integer id) {
        super("El personaje con ID: " + id + " no existe.");
    }
}
