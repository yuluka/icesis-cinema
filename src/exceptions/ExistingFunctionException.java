package exceptions;

public class ExistingFunctionException extends RuntimeException {

	public ExistingFunctionException() {
		super("La funci�n que est�s tratando de agendar ya ha sido agendada previamente.");
	}

}
