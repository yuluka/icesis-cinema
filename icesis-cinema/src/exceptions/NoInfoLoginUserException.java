package exceptions;

public class NoInfoLoginUserException extends RuntimeException{

	public NoInfoLoginUserException() {
		super("El usuario con el que estás intentando ingresar no tiene datos registrados porque no los"
				+ " escribiste.");
	}

}
