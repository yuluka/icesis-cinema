package model;

import java.util.ArrayList;

public class CinemaData {
	public static ArrayList<User> users = new ArrayList<User>();//Arraylist para guardar todos los users creados.

	public CinemaData() {
		
	}
	
	/**Recibe los datos del user que se quiere registrar y revisa si el Array con todos los users 
	est� vac�o. En caso de que s�, agrega el user sin m�s. En caso de que no, revisa si existe un 
	user con el mismo id del que se est� intentando crear y lo agrega, si no lo encuentra, o lanza 
	una excepci�n, si no lo encuentra*/
	public void registerUser(String name, String id) {
		User newUser = new User(name, id);
		
		if(users.size() != 0) {
			for (int i = 0; i < users.size(); i++) {
				if(!users.get(i).getUserID().equalsIgnoreCase(id)) {
					users.add(newUser);
				}else {
					/**Dise�ar y lanzar una excepci�n en caso de que se trate de registrar un user
					ya registrado*/
				}
			}
		}else {
			users.add(newUser);
		}
	}
	
	/** Busca si hay alg�n user con el id ingresado y devuelve un boolean para decir si lo hizo 
	o no.*/
	public boolean searchUser(String id) {
		boolean found = false;
		
		if(users.size() != 0) { //B�squeda lineal.
			for (int i = 0; i < users.size(); i++) {
				if(users.get(i).getUserID().equalsIgnoreCase(id)) {
					found = true;
				}
			}
		}
		
		return found;
	}
}
