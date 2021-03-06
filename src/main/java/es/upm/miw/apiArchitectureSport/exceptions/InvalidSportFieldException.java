package es.upm.miw.apiArchitectureSport.exceptions;

public class InvalidSportFieldException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Error datos Sport";

    public InvalidSportFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidSportFieldException() {
        this("");
    }

}
