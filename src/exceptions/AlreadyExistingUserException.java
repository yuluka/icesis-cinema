package exceptions;

public class AlreadyExistingUserException extends RuntimeException{

	public AlreadyExistingUserException(String id) {
		super("El usuario " + id + ", que estás intentando registrar, ya existe.");
	}
}
