package by.epam.lab.exceptions;

public class NonPositiveArgumentException extends IllegalArgumentException{

    public NonPositiveArgumentException(){
        super();
    }

    public NonPositiveArgumentException(String message){
        super(message);
    }

    public NonPositiveArgumentException(Exception e){
        super(e);
    }

    public NonPositiveArgumentException(String message, Exception e){
        super(message, e);
    }
}
