package exceptions;

public class OccupiedRoomException extends RuntimeException {

	public OccupiedRoomException() {
		super("La sala a la que est�s tratando de agregar la funci�n ya ha sido ocupada"
				+ " previamente.");
	}

}
