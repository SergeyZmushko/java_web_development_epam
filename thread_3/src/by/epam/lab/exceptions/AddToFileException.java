package by.epam.lab.exceptions;

public class AddToFileException extends RuntimeException{

    public AddToFileException(){
        super();
    }

    public AddToFileException(String message){
        super(message);
    }

    public AddToFileException(Exception e){
        super(e);
    }
}
