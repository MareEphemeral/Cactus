package org.cactus.pojo;

public class RProjectUser {
	private Integer ID;
	private Integer userID;
	private Integer projectID;
	
	public RProjectUser(){}

	public RProjectUser(Integer userID, Integer projectID) {
		super();
		this.userID = userID;
		this.projectID = projectID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	
	
}
