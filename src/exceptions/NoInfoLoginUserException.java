package exceptions;

public class NoInfoLoginUserException extends RuntimeException{

	public NoInfoLoginUserException() {
		super("El usuario con el que est�s intentando ingresar no tiene datos registrados porque no los"
				+ " escribiste.");
	}

}
