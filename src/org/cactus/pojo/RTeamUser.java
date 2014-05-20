package org.cactus.pojo;

public class RTeamUser {
	private Integer ID;
	private Integer teamID;
	private Integer userID;
	
	public RTeamUser(){}

	public RTeamUser(Integer teamID, Integer userID) {
		super();
		this.teamID = teamID;
		this.userID = userID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getTeamID() {
		return teamID;
	}

	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
}
