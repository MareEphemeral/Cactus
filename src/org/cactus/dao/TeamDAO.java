package org.cactus.dao;

import java.util.ArrayList;
import java.util.List;

import org.cactus.pojo.Group;
import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RTeamUser;
import org.cactus.pojo.Team;
import org.cactus.pojo.User;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeamDAO {
	
	PublicDAO pDAO;
	public TeamDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertTeam(Team team)
	{
		pDAO.publicInsert(team);
	}
	
	public void updateTeam(Team team)
	{
		pDAO.publicUpdate(team);
	}
	
	public void deleteTeam(Team team)
	{
		pDAO.publicDelete(team);
	}
	
	 public List<User> getUserByTeam(int teamID) throws HibernateException {
		 	UserDAO userD=new UserDAO();
		 	String[] types={"i"};
			Object[] paras={teamID};
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_USER_BY_TEAM);
			List<User> Trueresult = new ArrayList<User>();
			for (int i=0;i<Result.size();i++)
			{
				Object[] temp = (Object[])Result.get(i);				
				Trueresult.add(userD.getUser(((RTeamUser)temp[1]).getTeamID()));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	    }
	 
	
	 public Team getTeam(Integer gorupID) throws HibernateException {
	      return (Team) pDAO.publicSearchByID(gorupID, SQLCommand.FIND_TEAM_BY_ID);
	    }
	 
	 public List<Team> getGroupByCreator(Integer creatorID) throws HibernateException { 
			String[] types={"i"};
			Object[] paras={creatorID};
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_TEAM_BY_CREATOR);
			List<Team> Trueresult=new ArrayList<Team>();
			for (int i=0;i<Result.size();i++)
			{
				Trueresult.add((Team) Result.get(i));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	 }
}
