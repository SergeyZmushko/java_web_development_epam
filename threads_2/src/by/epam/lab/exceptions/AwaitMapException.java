package by.epam.lab.exceptions;

public class AwaitMapException extends RuntimeException {

    public AwaitMapException() {
        super();
    }

    public AwaitMapException(String message) {
        super(message);
    }

    public AwaitMapException(Exception e) {
        super(e);
    }
}
