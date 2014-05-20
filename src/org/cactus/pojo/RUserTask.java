package org.cactus.pojo;

public class RUserTask {
	private Integer ID;
	private Integer userID;
	private Integer TaskID;
	
	public RUserTask(){}

	public RUserTask(Integer userID, Integer taskID) {
		super();
		this.userID = userID;
		TaskID = taskID;
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

	public Integer getTaskID() {
		return TaskID;
	}

	public void setTaskID(Integer taskID) {
		TaskID = taskID;
	}
	
	
}
