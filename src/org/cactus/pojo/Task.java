package org.cactus.pojo;
import java.util.*;

public class Task {


	private Integer ID;
	private String taskName;
	private Date careateTime;
	private Date deadline;
	private int progress;
	private int taskSetID;
	private String taskDesc;
	private int creatorID;
	private int state;
	public Task(){}
	
	
	public Task(String taskName, Date careateTime, Date deadline,
			int progress, int taskSetID, String taskDesc, int creatorID,int state) {
		super();
		this.taskName = taskName;
		this.careateTime = careateTime;
		this.deadline = deadline;
		this.progress = progress;
		this.taskSetID = taskSetID;
		this.taskDesc = taskDesc;
		this.creatorID = creatorID;
		this.state= state;
	}

	

	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getCareateTime() {
		return careateTime;
	}
	public void setCareateTime(Date careateTime) {
		this.careateTime = careateTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getTaskSetID() {
		return taskSetID;
	}
	public void setTaskSetID(int taskSetID) {
		this.taskSetID = taskSetID;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public int getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}
}
