package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	
	private Date date;
	private String dateStr;
	private String hour;
	private String filmName;
	private double filmDuration;
	private int room;
	private String roomStr;
	
	public Function(Date date, String hour, String filmName, double filmDuration, int room) {
		this.date = date;
		setDateStr();
		this.hour = hour;
		this.filmName = filmName;
		this.filmDuration = filmDuration;
		this.room = room;
		setRoomStr();
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateStr() {
		return dateStr;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = sdf.format(date);
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

	public String getRoomStr() {
		return roomStr;
	}

	public void setRoomStr() {
		if(room == 1) {
			roomStr = "Sala media";
		}else {
			roomStr = "Sala pequeña";
		}
	}
}
