package org.cactus.pojo;

public class Team {
	private Integer ID;
	private String teamName;
	private String teamIntro;
	private Integer creatorID;
	
	public Team(){}

	public Team(String teamName, String teamIntro, Integer creatorID) {
		super();
		this.teamName = teamName;
		this.teamIntro = teamIntro;
		this.creatorID = creatorID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamIntro() {
		return teamIntro;
	}

	public void setTeamIntro(String teamIntro) {
		this.teamIntro = teamIntro;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	}
	
	
}
