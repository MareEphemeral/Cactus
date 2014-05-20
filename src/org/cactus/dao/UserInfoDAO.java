package org.cactus.dao;

import org.cactus.pojo.*;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserInfoDAO {
	
	PublicDAO pDAO;
	public UserInfoDAO(){
		pDAO=new PublicDAO();
	}
	
	public void updateUserInfo(UserInfo userInfo)
	{
		pDAO.publicUpdate(userInfo);
	}
	
	public UserInfo getUserInfoID(Integer userID) throws HibernateException
	{
		return (UserInfo) pDAO.publicSearchByID(userID, SQLCommand.FIND_USERINFO_BY_ID);
	}
	
	public UserInfo getUserInfoIDCMM(Integer userID) throws HibernateException
	{
		return (UserInfo) pDAO.publicSearchByID(userID, SQLCommand.FIND_USERINFO_BY_USER_ID);
	}
}
