package model;

import java.io.Serializable;

public class Seat implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean occupied;
	private int number;
	private int positionX;
	private int positionY;
	private Viewer viewer;
	
	public Seat(int number) {
		this.number = number;
		viewer = null;
		occupied = false;
		
		setPositionX();
		setPositionY();
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX() {
		if(number <= 7) {
			positionX = 1;
		}else if(number > 7 && number <= 14) {
			positionX = 2;
		}else if(number > 14 && number <= 21) {
			positionX = 3;
		}else if(number > 21 && number <= 28) {
			positionX = 4;
		}else if(number > 28 && number <= 35) {
			positionX = 5;
		}else if(number > 35 && number <= 42) {
			positionX = 6;
		}
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY() {
		positionY = 0;
	}

	public Viewer getViewer() {
		return viewer;
	}

	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}
	
	
}
