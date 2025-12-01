package delvalle.valles.alejandro.AlumnosApiRest.exceptions;

public class AlumnoNotFoundException extends RuntimeException {
    public AlumnoNotFoundException(int nia) {
        super("No se ha encontrado al alumno con NIA: " + nia);
    }
}
