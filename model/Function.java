package model;

import java.util.Date;

public class Function {
	
	private Date date;
	private String filmName;
	private double filmDuration;
	private int room;
	
	public Function(Date date, String filmName, double filmDuration, int room) {
		super();
		this.date = date;
		this.filmName = filmName;
		this.filmDuration = filmDuration;
		this.room = room;
	}

	public Date getDate() {
		return date;
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
