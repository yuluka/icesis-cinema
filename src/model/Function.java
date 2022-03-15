package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Function implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String dateStr;
	private String hour;
	private String filmName;
	private double filmDuration;
	private int room;
	private String roomStr;
	private Room roomA;
	
	public Function(Date date, String hour, String filmName, double filmDuration, int room) {
		this.date = date;
		setDateStr();
		this.hour = hour;
		this.filmName = filmName;
		this.filmDuration = filmDuration;
		this.room = room;
		setRoomStr();
		setRoomA();
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateStr() {
		return dateStr;
	}

	public void setDate(Date date) {
		this.date = date;
		setDateStr();
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
		setRoomStr();
		setRoomA();
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
	
	public void setRoomA() {		
		if(room == 1) {
			roomA = new Room("Sala media");
			generateMediumroomSeats();
		}else if(room == 2) {
			roomA = new Room("Sala pequeña");
			generateMiniroomSeats();
		}
	}
	
	private void generateMiniroomSeats() {
		for (int i = 0; i < 28; i++) {
			roomA.addSeats(new Seat(i+1));
		}
	}
	
	private void generateMediumroomSeats() {
		for (int i = 0; i < 42; i++) {
			roomA.addSeats(new Seat(i+1));
		}
	}
	
	public Room getRoomA() {
		return roomA;
	}
}
