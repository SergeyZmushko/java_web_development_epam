package by.epam.lab.exceptions;

import java.util.concurrent.Executors;

public class ListExecutionException extends RuntimeException {

    public ListExecutionException() {
        super();
    }

    public ListExecutionException(String message) {
        super(message);
    }

    public ListExecutionException(Exception e) {
        super(e);
    }
}
