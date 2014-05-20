package org.cactus.dao;

import java.util.List;

import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.User;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RProjectUserDAO {
	
	PublicDAO pDAO;
	public RProjectUserDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertMember(RProjectUser user)
	{
		pDAO.publicInsert(user);
	}
	
	public void deleteMember(RProjectUser user)
	{
		pDAO.publicDelete(user);
	}
	
	public void updateMember(RProjectUser user)
	{
		pDAO.publicUpdate(user);
	}
	
	
	public  RProjectUser GetRelation(Integer projectID, Integer userID) throws HibernateException {
		String[] types={"i","i"};
		Object[] paras={projectID,userID};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_RELATION_BY_PROJECT_USER);
		if (!Result.isEmpty()){
			return (RProjectUser) Result.get(0);
		}
			else return null;
	}
	
}
