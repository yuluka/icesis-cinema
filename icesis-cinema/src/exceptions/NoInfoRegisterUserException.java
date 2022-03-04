package exceptions;

public class NoInfoRegisterUserException extends RuntimeException{

	public NoInfoRegisterUserException() {
		super("No ha ingresado datos en los campos pertinentes. No se puede agregar un user vacío.");
	}

}
