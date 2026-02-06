package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

import DelValle.Valles.Alejandro.OrmHarryPotter.model.Varita;

public class VaritaNotFoundException extends RuntimeException {
    public VaritaNotFoundException() {
        super("La varita buscada no existe.");
    }

    public VaritaNotFoundException(Varita varita) {
        super(String.format("La varita con ID: %d no existe.", varita.getId()));
    }

    public VaritaNotFoundException(Integer id) {
        super(String.format("La varita con ID: %d no existe.", id));
    }
}
