package org.cactus.dao;

import java.util.List;

import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.RUserTask;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RGroupUserDAO {

	PublicDAO pDAO;
	public RGroupUserDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertMember(RGroupUser user)
	{
		pDAO.publicInsert(user);
	}
	
	public void deleteMember(RGroupUser user)
	{
		pDAO.publicDelete(user);
	}
	
	public void updateMember(RGroupUser user)
	{
		pDAO.publicUpdate(user);
	}
	
	
	public  RGroupUser GetRelation(Integer userID, Integer groupID) throws HibernateException {
		String[] types={"i","i"};
		Object[] paras={groupID,userID};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_RELATION_BY_GROUP_USER);
		if (!Result.isEmpty()){
			return (RGroupUser) Result.get(0);
		}
			else return null;
	}
	
	
	
}
