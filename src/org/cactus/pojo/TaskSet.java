package org.cactus.pojo;

public class TaskSet {
	
	private Integer ID;
	private String tasksetName;
	private Integer projectID;
	private Integer creatorID;

	public TaskSet(){}

	public TaskSet(String tasksetName, Integer projectID, Integer creatorID) {
		super();
		this.tasksetName = tasksetName;
		this.projectID = projectID;
		this.creatorID = creatorID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTasksetName() {
		return tasksetName;
	}

	public void setTasksetName(String tasksetName) {
		this.tasksetName = tasksetName;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	};
	
}
