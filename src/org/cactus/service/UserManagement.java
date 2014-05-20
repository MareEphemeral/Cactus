package org.cactus.service;

import org.cactus.dao.*;
import org.cactus.pojo.*;
import org.cactus.util.EmailMaker;
import org.cactus.util.MD5Util;
public class UserManagement {

	public String validateEmail(User targetUser)
	{
		 String result="Success";
		 EmailMaker valiMail= new EmailMaker("smtp.163.com");
		 String mailbody = "亲爱的"+targetUser.getUserName()+"，欢迎来到Cactus,请前往以下链接来完成注册  "+"<br><a>http://221.239.199.136:8888/Cactus/signupSupport.jsp?action=activate&id="
				 +targetUser.getID()+"&validateCode="+targetUser.getValidateCode()+"</a><br>如果您不能点击，请复制到浏览器访问。";
	     valiMail.setNeedAuth(true); 
	     valiMail.setSubject("Cactus注册验证");
	     valiMail.setBody(mailbody);
	     valiMail.setTo(targetUser.getMail());
	     valiMail.setFrom("project_cactus@163.com");
	     valiMail.setNamePass("project_cactus@163.com", "Wangsiyuan");
	     valiMail.sendout(); 
	     return result;
	}
	
	public String activiateUser(Integer userID,String validateCode)
	{
		String result="Activate Success";
		UserDAO userD=new UserDAO();
		User temp=userD.getUser(userID);
		if (temp.getValidateCode().equals(validateCode)){
			temp.setUserState(1);
			userD.updateUser(temp);
		}
		else result="Invalid Accesss";
		return result;
	}
	
	public String validateUser(String email, String password)
	{
		User tempUser = new User();
		String Result = "Validate Readt";
		
		UserDAO userD=new UserDAO();
		tempUser=userD.getUserByEmail(email);
		
		if (tempUser == null)
		{
			Result="No user";
		}
		else if (!tempUser.getPassword().equals(password))
		{
			Result="Wrong Password";
		}
		else
		{
			Result=tempUser.getID().toString();
		}
		return Result;
	}
	
	public String registerUser(String userName, String password,String email)
	{
		String result="Ready";
		UserDAO userD=new UserDAO();
		User targetUser=new User(password,userName, email,
				MD5Util.encode2hex(email), 0);
		try{
			userD.insertUser(targetUser);
			result=validateEmail(targetUser);
		}
		catch(Exception ex)
		{
			result="Register Failed";
		}	
		return result;
	}
	
	
	public User getMyInfomationByName(Integer userID)
	{
		User userTemp=new User();
		userTemp.setID(-1);
		UserDAO userD=new UserDAO();
		userTemp=userD.getUser(userID);
		return userTemp;	
	}
	
	public Integer getMyIDByName(String userName)
	{
		User tempUser = new User();
		String Result = "Ready";
		UserDAO userD=new UserDAO();
		tempUser=userD.getUserByName(userName);
		return tempUser.getID();
	}
	
	public UserInfo getMyDetailInfo(Integer userID)
	{
		UserInfoDAO userInfoD=new UserInfoDAO();
		return userInfoD.getUserInfoIDCMM(userID);
	}
	
	public String updateUserInfo(String realName, int age, String phone,String selfIntro, String avatar, String workPlacel,Integer userID)
	{
		String result="Update Ready";
		UserInfoDAO userInfoD=new UserInfoDAO();
		Integer userInfoID=userInfoD.getUserInfoIDCMM(userID).getID();
		
		UserInfo userInfo = new UserInfo(userID,realName,age,phone,selfIntro,avatar,workPlacel);
	    userInfo.setID(userInfoID);        
		try{
			userInfoD.updateUserInfo(userInfo);
			result="Update Success";
		}
		catch(Exception ex)
		{
			result="Update Failed";
		}	
		return result;
	}
	
}
