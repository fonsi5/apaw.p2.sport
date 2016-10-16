package es.upm.miw.apiArchitectureSport.exceptions;

public class InvalidUserFieldException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Error datos usuario";

    public InvalidUserFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidUserFieldException() {
        this("");
    }

}
