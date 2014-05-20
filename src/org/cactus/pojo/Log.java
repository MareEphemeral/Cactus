package org.cactus.pojo;

public class Log {
	private Integer ID;
	private Integer logLevel;
	private String  logBody;
	private Integer logParticipant;
	
	public Log(){}

	public Log(Integer logLevel, String logBody, Integer logParticipant) {
		super();
		this.logLevel = logLevel;
		this.logBody = logBody;
		this.logParticipant = logParticipant;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(Integer logLevel) {
		this.logLevel = logLevel;
	}

	public String getLogBody() {
		return logBody;
	}

	public void setLogBody(String logBody) {
		this.logBody = logBody;
	}

	public Integer getLogParticipant() {
		return logParticipant;
	}

	public void setLogParticipant(Integer logParticipant) {
		this.logParticipant = logParticipant;
	}
	
	
	
}
