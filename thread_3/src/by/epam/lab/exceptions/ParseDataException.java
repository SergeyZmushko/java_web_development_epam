package by.epam.lab.exceptions;

public class ParseDataException extends RuntimeException{

    public ParseDataException(){
        super();
    }

    public ParseDataException(Exception e){
        super(e);
    }
}
