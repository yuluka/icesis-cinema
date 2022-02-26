package model;

import java.util.ArrayList;

import exceptions.AlreadyExistingUserException;
import exceptions.NoInfoLoginUserException;
import exceptions.NoInfoRegisterUserException;
import exceptions.NonExistingUserException;

public class CinemaData {
	public static ArrayList<User> users = new ArrayList<User>();//Arraylist para guardar todos los users creados.

	private User adminUser = new User("Admin", "123");//Usuario administrador.
	
	public CinemaData() {
		users.add(adminUser);
	}
	
	/**Recibe los datos del user que se quiere registrar y revisa si el Array con todos los users 
	está vacío. En caso de que sí, agrega el user sin más. En caso de que no, revisa si existe un 
	user con el mismo id del que se está intentando crear y lo agrega, si no lo encuentra, o lanza 
	una excepción, si no lo encuentra*/
	public void registerUser(String name, String id) throws AlreadyExistingUserException, NoInfoRegisterUserException{
		User newUser = new User(name, id);
		
		if(name.equals("") || id.equals("")) {
			throw new NoInfoRegisterUserException();
		}else {
			if(users.size() != 0) {
				for (int i = 0; i < users.size(); i++) {
					if(!users.get(i).getUserID().equalsIgnoreCase(id)) {
						users.add(newUser);
					}else {
						throw new AlreadyExistingUserException(id);
					}
				}
			}else {
				users.add(newUser);
			}
		}
	}
	
	/** Busca si hay algún user con el id ingresado y devuelve un boolean para decir si lo hizo 
	o no.*/
	public boolean searchUser(String id) throws NonExistingUserException, NoInfoLoginUserException{
		boolean found = false;

		if(id.equals("")) {
			throw new NoInfoLoginUserException();
		}else {
			if(users.size() != 0) { //Búsqueda lineal.
				for (int i = 0; i < users.size(); i++) {
					if(users.get(i).getUserID().equalsIgnoreCase(id)) {
						found = true;
					}
				}
			}
			
			if(!found) {
				throw new NonExistingUserException(id);
			}
		}
		
		return found;
	}
}
