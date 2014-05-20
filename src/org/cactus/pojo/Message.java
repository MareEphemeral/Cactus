package org.cactus.pojo;

import java.util.Date;

public class Message {
	private Integer ID;
	private int senderID;
	private int receiverID;
	private int messageLevel;
	private Date timestamp;
	private String messageBody;
	
	public Message(){}

	public Message(int senderID, int receiverID, int messageLevel,
			Date timestamp, String messageBody) {
		super();
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.messageLevel = messageLevel;
		this.timestamp = timestamp;
		this.messageBody = messageBody;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}

	public int getMessageLevel() {
		return messageLevel;
	}

	public void setMessageLevel(int messageLevel) {
		this.messageLevel = messageLevel;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	
	
	
	
}
