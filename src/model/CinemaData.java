package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import exceptions.AlreadyExistingUserException;
import exceptions.ExistingFunctionException;
import exceptions.NoInfoAddFunctionException;
import exceptions.NoInfoLoginUserException;
import exceptions.NoInfoRegisterUserException;
import exceptions.NonExistingUserException;
import exceptions.OccupiedRoomException;

public class CinemaData {
	public static ArrayList<User> users = new ArrayList<User>();//Arraylist para guardar todos los users creados.
	public static ArrayList<Function> functions = new ArrayList<Function>();
		
	private User adminUser = new User("Admin", "123");//Usuario administrador.
	
	public CinemaData() {
		users.add(adminUser);
	}
	
	/**Recibe los datos del user que se quiere registrar y revisa si el Array con todos los users 
	est� vac�o. En caso de que s�, agrega el user sin m�s. En caso de que no, revisa si existe un 
	user con el mismo id del que se est� intentando crear y lo agrega, si no lo encuentra, o lanza 
	una excepci�n, si no lo encuentra*/
	public void registerUser(String name, String id) throws AlreadyExistingUserException, NoInfoRegisterUserException{
		User newUser = new User(name, id);
		
		if(name.equals("") || id.equals("")) {
			throw new NoInfoRegisterUserException();
		}else {
			if(users.size() != 0) {
				for (int i = 0; i < users.size(); i++) {
					if(!users.get(i).getUserID().equalsIgnoreCase(id)) {
						users.add(newUser);
						i = users.size();
					}else {
						throw new AlreadyExistingUserException(id);
					}
				}
			}else {
				users.add(newUser);
			}
		}
	}
	
	/** Busca si hay alg�n user con el id ingresado y devuelve un boolean para decir si lo hizo 
	o no.*/
	public boolean searchUser(String id) throws NonExistingUserException, NoInfoLoginUserException{
		boolean found = false;

		if(id.equals("")) {
			throw new NoInfoLoginUserException();
		}else {
			if(users.size() != 0) { //B�squeda lineal.
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
	
	public void addFunction(String dateStr, String filmName, double filmDuration, int room) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		Function newFunction = new Function(date, filmName, filmDuration, room);
	
		if(filmName.isEmpty() || room != 1 && room != 2){
			throw new NoInfoAddFunctionException();
		}else if(searchFunction(filmName,dateStr)) {
			throw new ExistingFunctionException();
		}else if(searchFunctionByRoom(dateStr,room)) {
			throw new OccupiedRoomException();
		}else if(functions.size() == 0) {
			functions.add(newFunction);
		}else {
			functions.add(newFunction);
		}
	}
	
	public boolean searchFunction(String filmName, String dateStr) {
		boolean found = false;
		
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).getFilmName().equalsIgnoreCase(filmName) &&
					functions.get(i).getDateStr().equals(dateStr)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public boolean searchFunctionByRoom(String dateStr, int room) {
		boolean found = false;
		
		for (int i = 0; i < functions.size(); i++) {
			System.out.println(functions.get(i).getDateStr());
			System.out.println(dateStr);
			
			if(functions.get(i).getDateStr().equals(dateStr) && 
					functions.get(i).getRoom() == room) {
				found = true;
			}
		}
		
		return found;
	}
}
