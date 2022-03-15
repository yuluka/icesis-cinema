package exceptions;

public class NonExistingUserException extends RuntimeException{
	
	public NonExistingUserException(String id) {
		super("El usuario " + id + ", con el que intentas iniciar sesi�n, no existe.");
	}
}
