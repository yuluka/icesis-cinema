package exceptions;

public class AlreadyExistingUserException extends RuntimeException{

	public AlreadyExistingUserException(String id) {
		super("El usuario " + id + ", que est�s intentando registrar, ya existe.");
	}
}
