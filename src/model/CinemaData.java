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
	public static ArrayList<Viewer> viewers = new ArrayList<Viewer>();
		
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
	
	public void addFunction(String dateStr, String hour, String filmName, double filmDuration, int room) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		Function newFunction = new Function(date, hour, filmName, filmDuration, room);
	
		if(filmName.isEmpty() || hour.isEmpty() || room != 1 && room != 2){
			throw new NoInfoAddFunctionException();
		}else if(searchFunction(filmName,dateStr,hour)) {
			throw new ExistingFunctionException();
		}else if(searchFunctionByRoom(dateStr,room,hour)) {
			throw new OccupiedRoomException();
		}else if(functions.size() == 0) {
			functions.add(newFunction);
		}else {
			functions.add(newFunction);
		}
	}
	
	public boolean searchFunction(String filmName, String dateStr, String hour) {
		boolean found = false;
		
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).getFilmName().equalsIgnoreCase(filmName) &&
					functions.get(i).getDateStr().equals(dateStr) &&
					functions.get(i).getHour().equals(hour)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public boolean searchFunctionByRoom(String dateStr, int room, String hour) {
		boolean found = false;
		
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).getDateStr().equals(dateStr) && 
					functions.get(i).getRoom() == room &&
					functions.get(i).getHour().equals(hour)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public void removeFunction(Function functionToRemove) {
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).equals(functionToRemove)) {
				functions.remove(i);
				i = functions.size();
			}
		}
	}
	
	public void addViewer(String name, String id) {
		Viewer newViewer = new Viewer(name, id);
		
		viewers.add(newViewer);
	}
	
	public int searchFunctionToReplace(Function function) {
		int index = 0;
		
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).equals(function)) {
				index = i;
				i = functions.size();
			}
		}
		
		return index;
	}
}
