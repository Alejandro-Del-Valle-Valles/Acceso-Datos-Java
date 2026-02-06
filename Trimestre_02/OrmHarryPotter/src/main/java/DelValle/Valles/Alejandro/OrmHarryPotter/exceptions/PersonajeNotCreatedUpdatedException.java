package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;

public class PersonajeNotCreatedUpdatedException extends RuntimeException {
    public PersonajeNotCreatedUpdatedException() {
        super("El personaje no se pudo crear o actualizar.");
    }

    public PersonajeNotCreatedUpdatedException(Personaje personaje) {
        super("El personaje con ID: " + personaje.getId() + " no se pudo crear o actualizar.");
    }

    public PersonajeNotCreatedUpdatedException(Integer id) {
        super("El personaje con ID: " + id + " no se pudo crear o actualizar.");
    }
}
