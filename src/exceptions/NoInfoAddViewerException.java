package exceptions;

public class NoInfoAddViewerException extends RuntimeException{

	public NoInfoAddViewerException() {
		super("No has llenado toda la informaci�n requerida para crear al epectador.");
	}

}
