package org.cactus.pojo;

public class Document {
	private Integer ID;
	private Integer fileID;
	private String version;
	
	public Document(){}
	
	public Document(Integer fileID, String version) {
		super();
		this.fileID = fileID;
		this.version = version;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getFileID() {
		return fileID;
	}

	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	
	
}
