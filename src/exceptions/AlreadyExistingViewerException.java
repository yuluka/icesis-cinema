package exceptions;

public class AlreadyExistingViewerException extends RuntimeException {

	public AlreadyExistingViewerException() {
		super("El espectador que est�s tratando de agregar ya ha sido registrado previamente.");
	}

}
