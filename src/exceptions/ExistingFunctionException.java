package exceptions;

public class ExistingFunctionException extends RuntimeException {

	public ExistingFunctionException() {
		super("La función que estás tratando de agendar ya ha sido agendada previamente.");
	}

}
