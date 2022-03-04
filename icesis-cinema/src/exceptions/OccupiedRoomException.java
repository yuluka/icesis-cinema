package exceptions;

public class OccupiedRoomException extends RuntimeException {

	public OccupiedRoomException() {
		super("La sala a la que estás tratando de agregar la función ya ha sido ocupada"
				+ " previamente.");
	}

}
