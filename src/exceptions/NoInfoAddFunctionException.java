package exceptions;

public class NoInfoAddFunctionException extends RuntimeException {

	public NoInfoAddFunctionException() {
		super("No has llenado toda la informaci�n necesaria para agendar una funci�n.");
	}

}
