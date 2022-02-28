package by.epam.lab.exceptions;

public class NegativeArgumentException extends IllegalArgumentException{
    public NegativeArgumentException(){
        super();
    }

    public NegativeArgumentException(String message){
        super(message);
    }

    public NegativeArgumentException(Exception e){
        super(e);
    }

    public NegativeArgumentException(String message, Exception e){
        super(message, e);
    }
}
