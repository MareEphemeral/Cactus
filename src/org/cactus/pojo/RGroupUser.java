package org.cactus.pojo;

public class RGroupUser {
	private Integer ID;
	private int groupID;
	private int userID;
	
	public RGroupUser(){}

	public RGroupUser(int groupID, int userID) {
		super();
		this.groupID = groupID;
		this.userID = userID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
