package by.epam.lab.exceptions;

public class AwaitListException extends RuntimeException {

    public AwaitListException() {
        super();
    }

    public AwaitListException(String message) {
        super(message);
    }

    public AwaitListException(Exception e) {
        super(e);
    }
}
