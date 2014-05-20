package org.cactus.pojo;

public class Group {
	private Integer ID;
	private String groupName;
	private byte[] authorityMap;
	private int projectID;
	
	public Group(){}

	public Group(String groupName, byte[] authorityMap, int projectID) {
		super();
		this.groupName = groupName;
		this.authorityMap = authorityMap;
		this.projectID = projectID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public byte[] getAuthorityMap() {
		return authorityMap;
	}

	public void setAuthorityMap(byte[] authorityMap) {
		this.authorityMap = authorityMap;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}


	
}
