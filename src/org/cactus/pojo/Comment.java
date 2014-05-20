package org.cactus.pojo;

import java.util.Date;

public class Comment {
	
	private Integer ID;
	private int commentType;
	private String commentBody;
	private String commentTitle;
	private int senderID;
	private int taskID;
	private Date commentTime;
	private int belongTopicID;
	
	public Comment(){}
	
	public Comment(int commentType, String commentBody, String commentTitle,
			int senderID, int taskID, Date commentTime, int belongTopicID) {
		super();
		this.commentType = commentType;
		this.commentBody = commentBody;
		this.commentTitle = commentTitle;
		this.senderID = senderID;
		this.taskID = taskID;
		this.commentTime = commentTime;
		this.belongTopicID = belongTopicID;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public int getCommentType() {
		return commentType;
	}
	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public int getBelongTopicID() {
		return belongTopicID;
	}
	public void setBelongTopicID(int belongTopicID) {
		this.belongTopicID = belongTopicID;
	}
	
	
}
