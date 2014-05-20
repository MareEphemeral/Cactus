package org.cactus.pojo;

public class File {
	private Integer ID;
	private String fileUrl;
	private String fileName;
	private int storeType;
	private int targetID;
	
	public File(){}

	public File(String fileUrl, String fileName, int storeType, int targetID) {
		super();
		this.fileUrl = fileUrl;
		this.fileName = fileName;
		this.storeType = storeType;
		this.targetID = targetID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStoreType() {
		return storeType;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}

	public int getTargetID() {
		return targetID;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}
	
	
}
