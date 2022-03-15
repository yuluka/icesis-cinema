package exceptions;

public class AlreadyExistingViewerException extends RuntimeException {

	public AlreadyExistingViewerException() {
		super("El espectador que estás tratando de agregar ya ha sido registrado previamente.");
	}

}
