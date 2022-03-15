package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import exceptions.AlreadyExistingUserException;
import exceptions.AlreadyExistingViewerException;
import exceptions.ExistingFunctionException;
import exceptions.NoInfoAddFunctionException;
import exceptions.NoInfoAddViewerException;
import exceptions.NoInfoLoginUserException;
import exceptions.NoInfoRegisterUserException;
import exceptions.NonExistingUserException;
import exceptions.OccupiedRoomException;

public class CinemaData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ArrayList<User> users = new ArrayList<User>();//Arraylist para guardar todos los users creados.
	
	public static ArrayList<Function> functions = new ArrayList<Function>();
	public static ArrayList<Function> functionsHistorial = new ArrayList<Function>();
	
	public static ArrayList<Viewer> viewers = new ArrayList<Viewer>();
		
	private static User adminUser = new User("Admin", "123");//Usuario administrador.
	
	
	public static void loadData() {
		loadUsers();
		loadFunctions();
		//loadHistorialFunctions();
		loadViewers();
	}
	
	@SuppressWarnings("unchecked")
	public static void loadUsers() {
		try {
			File file = new File("data/Users data.temp");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList<User>) ois.readObject();
			
			ois.close();
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadFunctions() {
		try {
			File file = new File("data/Functions data.temp");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			functions = (ArrayList<Function>) ois.readObject();
			
			ois.close();
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	public static void loadHistorialFunctions() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static void loadViewers() {
		try {
			File file = new File("data/Viewer data.temp");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			viewers = (ArrayList<Viewer>) ois.readObject();
			
			ois.close();
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	public static void saveUsers() {
		try {
			File file = new File("data/Users data.temp");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			
			oos.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	public static void saveFunctions() {
		try {
			File file = new File("data/Functions data.temp");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(functions);
			
			oos.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	public static void saveViewers() {
		try {
			File file = new File("data/Viewer data.temp");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(viewers);
			
			oos.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/**Recibe los datos del user que se quiere registrar y revisa si el Array con todos los users 
	está vacío. En caso de que sí, agrega el user sin más. En caso de que no, revisa si existe un 
	user con el mismo id del que se está intentando crear y lo agrega, si no lo encuentra, o lanza 
	una excepción, si no lo encuentra*/
	public static void registerUser(String name, String id) throws AlreadyExistingUserException, NoInfoRegisterUserException{
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
		
		saveUsers();
	}
	
	/** Busca si hay algún user con el id ingresado y devuelve un boolean para decir si lo hizo 
	o no.*/
	public static boolean searchUser(String id) throws NonExistingUserException, NoInfoLoginUserException{
		boolean found = false;

		if(id.equals("")) {
			throw new NoInfoLoginUserException();
		}else if(adminUser.getUserID().equalsIgnoreCase(id)) {
			found = true;
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
	
	public static void searchUserToReplace(User editUser, String newId, String newName) {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).equals(editUser)) {
				users.get(i).setUserName(newName);
		    	users.get(i).setUserID(newId);
				
				i = users.size();
			}
		}
		
		saveUsers();
	}
	
	public static void addFunction(String dateStr, String hour, String filmName, double filmDuration, int room) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		Function newFunction = new Function(date, hour, filmName, filmDuration, room);
	
		if(filmName.isEmpty() || hour.isEmpty() || room != 1 && room != 2){
			throw new NoInfoAddFunctionException();
		}else if(searchFunction(filmName,dateStr,hour)) {
			throw new ExistingFunctionException();
		}else if(searchFunctionByRoom(dateStr,room,hour)) {
			throw new OccupiedRoomException();
		}else {
			if(!compareDates(date)) {
				functions.add(newFunction);
			}
			
			functionsHistorial.add(newFunction);
		}
		
		saveFunctions();
	}
	
	public static boolean searchFunction(String filmName, String dateStr, String hour) {
		boolean found = false;
		
		for (int i = 0; i < functionsHistorial.size(); i++) {
			if(functionsHistorial.get(i).getFilmName().equalsIgnoreCase(filmName) &&
					functionsHistorial.get(i).getDateStr().equals(dateStr) &&
					functionsHistorial.get(i).getHour().equals(hour)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public static boolean searchFunctionByRoom(String dateStr, int room, String hour) {
		boolean found = false;
		
		for (int i = 0; i < functionsHistorial.size(); i++) {
			if(functionsHistorial.get(i).getDateStr().equals(dateStr) && 
					functionsHistorial.get(i).getRoom() == room &&
					functionsHistorial.get(i).getHour().equals(hour)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public static Function searchFunction(Function function) {
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).getRoom() == function.getRoom() && functions.get(i).getDate().equals(function.getDate()) &&
					functions.get(i).getHour().equalsIgnoreCase(function.getHour())) {
				function = functions.get(i);
				break;
			}
		}		
		
		return function;
	}
	
	public static void removeFunction(Function functionToRemove) {
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).equals(functionToRemove)) {
				functions.remove(i);
				i = functions.size();
			}
		}
		
		saveFunctions();
	}
	
	public static int searchFunctionToReplace(Function function) {
		int index = 0;
		
		for (int i = 0; i < functions.size(); i++) {
			if(functions.get(i).equals(function)) {
				index = i;
				i = functions.size();
			}
		}
		
		return index;
	}
	
	public static boolean compareDates(Date functionDate) {
		boolean pastDate = false;
		
		Date now = new Date();
	
		if(now.getTime() < functionDate.getTime()) {
			pastDate = false;
		}else {
			pastDate = true;
		}
		
		return pastDate;
	}
	
	public static void removePastFunctions(Function function) {
		if(compareDates(function.getDate())) {
			removeFunction(function);
		}
		
		saveFunctions();
	}
	
	public static void addViewer(String name, String id) {
		Viewer newViewer = new Viewer(name, id);
		
		if(name.isEmpty() || id.isEmpty()) {
			throw new NoInfoAddViewerException();
		}else if(searchViewer(newViewer)) { 
			throw new AlreadyExistingViewerException();
		}else {
			viewers.add(newViewer);
		}
	}
	
	public static boolean searchViewer(Viewer newViewer) {
		boolean problem = false;
		
		for (int i = 0; i < viewers.size(); i++) {
			if(!viewers.get(i).getName().equalsIgnoreCase(newViewer.getName()) && 
					viewers.get(i).getId().equalsIgnoreCase(newViewer.getId())) {
				problem = true;
			}
		}
		
		return problem;
	}
	
	public static void removeViewer(Viewer viewerToRemove) {
		boolean aux = false;
		
		for (int i = 0; i < functions.size() && !aux; i++) {
			for (int j = 0; j < functions.get(i).getRoomA().getSeats().size() && !aux; j++) {
				
				if(functions.get(i).getRoomA().getSeats().get(j).isOccupied()) {
					Viewer viewern = functions.get(i).getRoomA().getSeats().get(j).getViewer();
					
					if(viewern.equals(viewerToRemove)) {
						functions.get(i).getRoomA().getSeats().get(j).setOccupied(false);
						functions.get(i).getRoomA().getSeats().get(j).setViewer(null);
						aux = true;
					}
				}
			}
		}
	}
}
