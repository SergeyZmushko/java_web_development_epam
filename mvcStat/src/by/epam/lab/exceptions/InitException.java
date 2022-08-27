package by.epam.lab.exceptions;

public class InitException extends Exception {
	
	public InitException() {
		super();
	}
	
	public InitException(String message) {
		super(message);
	}
	
	public InitException(Exception e) {
		super(e);
	}

}
