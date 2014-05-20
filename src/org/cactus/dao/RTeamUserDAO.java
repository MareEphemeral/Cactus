package org.cactus.dao;

import java.util.List;

import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.RTeamUser;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RTeamUserDAO {
	
	PublicDAO pDAO;
	public RTeamUserDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertMember(RTeamUser team)
	{
		pDAO.publicInsert(team);
	}
	
	public void deleteMember(RTeamUser team)
	{
		pDAO.publicDelete(team);
	}
	
	public void updateMember(RTeamUser team)
	{
		pDAO.publicUpdate(team);
	}
	
	
	public  RTeamUser GetRelation(Integer userID, Integer teamID) throws HibernateException {
		String[] types={"i","i"};
		Object[] paras={teamID,userID};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_RELATION_BY_TEAM_USER);
		if (!Result.isEmpty()){
			return (RTeamUser) Result.get(0);
		}
			else return null;
	}
	
	
	
}
