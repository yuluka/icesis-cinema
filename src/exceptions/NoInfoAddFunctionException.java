package exceptions;

public class NoInfoAddFunctionException extends RuntimeException {

	public NoInfoAddFunctionException() {
		super("No has llenado toda la información necesaria para agendar una función.");
	}

}
