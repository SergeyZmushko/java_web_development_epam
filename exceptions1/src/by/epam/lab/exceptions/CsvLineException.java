package by.epam.lab.exceptions;

public class CsvLineException extends Exception{
    public CsvLineException(){
        super();
    }

    public CsvLineException(String message){
        super(message);
    }

    public CsvLineException(Exception e){
        super(e);
    }

    public CsvLineException(String message, Exception e){
        super(message, e);
    }
}
