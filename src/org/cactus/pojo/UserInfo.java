package org.cactus.pojo;

public class UserInfo {
	private Integer ID;
	private int userID;
	private String realName;
	private int age;
	private String phone;
	private String selfIntro;
	private String avatar;
	private String workPlace;
	
	public UserInfo(){}
	
	public UserInfo(int userID, String realName, int age, String phone,
			String selfIntro, String avatar, String workPlace) {
		super();
		this.userID = userID;
		this.realName = realName;
		this.age = age;
		this.phone = phone;
		this.selfIntro = selfIntro;
		this.avatar = avatar;
		this.workPlace = workPlace;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userinfoID) {
		this.userID = userinfoID;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSelfIntro() {
		return selfIntro;
	}

	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	
	
	
}
