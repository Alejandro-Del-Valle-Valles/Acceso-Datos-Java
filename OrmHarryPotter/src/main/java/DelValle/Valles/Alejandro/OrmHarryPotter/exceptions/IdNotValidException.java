package DelValle.Valles.Alejandro.OrmHarryPotter.exceptions;

public class IdNotValidException extends RuntimeException {

    public IdNotValidException() {
        super("El ID especificado no es válido.");
    }

    public IdNotValidException(Integer id) {
        super(String.format("El ID: %d no es válido.", id));
    }
}