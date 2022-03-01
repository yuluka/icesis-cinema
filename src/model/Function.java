package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	
	private Date date;
	private String hour;
	private String filmName;
	private double filmDuration;
	private int room;
	
	public Function(Date date, String hour, String filmName, double filmDuration, int room) {
		this.date = date;
		this.hour = hour;
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
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
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
