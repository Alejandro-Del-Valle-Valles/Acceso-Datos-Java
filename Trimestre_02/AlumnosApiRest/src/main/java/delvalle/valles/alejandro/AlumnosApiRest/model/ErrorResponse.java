package delvalle.valles.alejandro.AlumnosApiRest.model;

public class ErrorResponse {

    private String message;
    private String error;

    public ErrorResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}
