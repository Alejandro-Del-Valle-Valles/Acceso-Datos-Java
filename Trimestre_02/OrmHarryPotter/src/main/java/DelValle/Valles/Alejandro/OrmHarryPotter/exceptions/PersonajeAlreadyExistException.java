package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Personaje;

public class PersonajeAlreadyExistException extends RuntimeException {

    public PersonajeAlreadyExistException() {
        super("El personaje ya existe.");
    }

    public PersonajeAlreadyExistException(Personaje personaje) {
        super("El personaje con ID: " + personaje.getId() + " ya existe.");
    }

    public PersonajeAlreadyExistException(Integer id) {
        super("El personaje con ID: " + id + " ya existe.");
    }
}
