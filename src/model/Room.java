package model;

import java.util.ArrayList;

public class Room {

	private ArrayList<Seat> seats;
	private String name;
	
	public Room(String name) {
		seats = new ArrayList<>();
		this.name = name;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
	public void addSeats(Seat newSeat) {
		seats.add(newSeat);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
