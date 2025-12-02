package delvalle.valles.alejandro.AlumnosApiRest.exceptions;

public class AlumnoAlreadyExistsException extends RuntimeException {
    public AlumnoAlreadyExistsException(int nia) {
        super("El alumno con NIA: " + nia + " ya existe.");
    }
}
