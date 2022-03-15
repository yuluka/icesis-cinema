package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userID;
	
	public User(String userName, String userID) {
		super();
		this.userName = userName;
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
}
