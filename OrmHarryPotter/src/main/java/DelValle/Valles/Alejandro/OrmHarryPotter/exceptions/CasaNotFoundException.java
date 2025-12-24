package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

public class CasaNotFoundException extends RuntimeException {

    public CasaNotFoundException() {
        super("No se ha encontrado la casa especificada.");
    }

    public CasaNotFoundException(String message) {
        super("No se ha encontrado la casa " + message);
    }
}
