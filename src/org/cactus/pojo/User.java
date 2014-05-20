package org.cactus.pojo;

public class User {
	private Integer ID;
	private String password;
	private String userName;
	private String mail;
	private String validateCode;
	private Integer userState;
	
    public User(){}

    
	public User(String password, String userName, String mail,
			String validateCode, Integer userState) {
		super();
		this.password = password;
		this.userName = userName;
		this.mail = mail;
		this.validateCode = validateCode;
		this.userState = userState;
	}


	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public User(String password, String userName, String mail) {
		super();
		this.password = password;
		this.userName = userName;
		this.mail = mail;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
     
}
