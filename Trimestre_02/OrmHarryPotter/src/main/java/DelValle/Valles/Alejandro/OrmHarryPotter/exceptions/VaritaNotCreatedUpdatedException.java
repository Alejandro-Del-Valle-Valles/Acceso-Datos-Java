package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;

public class VaritaNotCreatedUpdatedException extends RuntimeException {
    public VaritaNotCreatedUpdatedException() {
        super("La varita no se pudo crear o actualizar.");
    }

    public VaritaNotCreatedUpdatedException(Varita varita) {
        super("La varita con ID: " + varita.getId() + "no se pudo crear o actualizar.");
    }

    public VaritaNotCreatedUpdatedException(Integer id) {
        super("La varita con ID: " + id + "no se pudo crear o actualizar.");
    }
}
