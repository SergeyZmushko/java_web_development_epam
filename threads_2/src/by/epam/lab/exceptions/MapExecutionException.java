package by.epam.lab.exceptions;

public class MapExecutionException extends RuntimeException {

    public MapExecutionException() {
        super();
    }

    public MapExecutionException(String message) {
        super(message);
    }

    public MapExecutionException(Exception e) {
        super(e);
    }
}
