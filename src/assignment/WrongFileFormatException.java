package assignment;

public class WrongFileFormatException extends Exception{
	String error;
	public WrongFileFormatException(String var) {
		super(var);
		error = var;

	}
}
