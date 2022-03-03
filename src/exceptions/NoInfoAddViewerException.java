package exceptions;

public class NoInfoAddViewerException extends RuntimeException{

	public NoInfoAddViewerException() {
		super("No has llenado toda la información requerida para crear al epectador.");
	}

}
