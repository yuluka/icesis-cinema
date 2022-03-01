package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	
	private Date date;
	//Falta agregar la hora de la función y un textField para que el usuario la elija.
	private String filmName;
	private double filmDuration;
	private int room;
	
	public Function(Date date, String filmName, double filmDuration, int room) {
		this.date = date;
		this.filmName = filmName;
		this.filmDuration = filmDuration;
		this.room = room;
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		
		return dateStr;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public double getFilmDuration() {
		return filmDuration;
	}

	public void setFilmDuration(double filmDuration) {
		this.filmDuration = filmDuration;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	
	
}
