package org.cactus.dao;

import java.util.List;

import org.cactus.pojo.User;
import org.cactus.util.*;
import org.hibernate.HibernateException;

public class UserDAO {
	
	PublicDAO pDAO;
	public UserDAO(){
		pDAO=new PublicDAO();
	}
	
	public User getUserByEmail(String email) throws HibernateException {
		String[] types={"s"};
		Object[] paras={email};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_USER_BY_MAIL);
		if (!Result.isEmpty()){
			return (User) Result.get(0);
		}
			else return null;
	}
	
	public User getUserByName(String userName) throws HibernateException {
		String[] types={"s"};
		Object[] paras={userName};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_USER_BY_NAME);
		if (!Result.isEmpty()){
			return (User) Result.get(0);
		}
			else return null;
	}
	
	public User getUser(Integer userID) throws HibernateException {
		return (User)pDAO.publicSearchByID(userID, SQLCommand.FIND_USER_BY_ID);
	}
	
	public void insertUser(User user)
	{
		pDAO.publicInsert(user);
	}
	
	public void deleteUser(User user)
	{
		pDAO.publicUpdate(user);
	}
	
	public void updateUser(User user)
	{
		pDAO.publicUpdate(user);
	}
}
