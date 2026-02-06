package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;

public class VaritaAlreadyExistException extends RuntimeException {

    public VaritaAlreadyExistException() {
        super("La varita ya existe.");
    }

    public VaritaAlreadyExistException(Varita varita) {
        super("La varita con ID: " + varita.getId() + " ya existe.");
    }

    public VaritaAlreadyExistException(Integer id) {
        super("La varita con ID: " + id + " ya existe.");
    }
}
