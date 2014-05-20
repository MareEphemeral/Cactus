package org.cactus.pojo;

public class Project {


	private Integer ID;
	private String projectName;
	private String projectIntroduction;
	private Integer creatorID;
	
	public Project(String projectName, String projectIntroduction,
			Integer creatorID) {
		super();
		this.projectName = projectName;
		this.projectIntroduction = projectIntroduction;
		this.creatorID = creatorID;
	}

	public Project(){}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIntroduction() {
		return projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	}

	
	
}
