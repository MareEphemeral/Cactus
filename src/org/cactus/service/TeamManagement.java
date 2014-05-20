package org.cactus.service;

import java.util.List;

import org.cactus.dao.GroupDAO;
import org.cactus.dao.RGroupUserDAO;
import org.cactus.dao.RTeamUserDAO;
import org.cactus.dao.TeamDAO;
import org.cactus.pojo.Group;
import org.cactus.pojo.Team;
import org.cactus.pojo.User;

public class TeamManagement {
	
	public String CreateTeam(String teamName, String teamIntro, Integer creatorID){	
		String result="Ready";
		TeamDAO teamD=new TeamDAO();
		try{
			teamD.InsertTeam(teamName, teamIntro, creatorID);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
	
	public Team GetTeamID(Integer teamID){
		
		String result="Ready";
		TeamDAO teamD=new TeamDAO();
		Team team;
		try{
			team=teamD.getTeam(teamID);
			result="Get Success";
			return team;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
	
	public String DeleteMember(Integer memberID,Integer teamID)
	{
		String result="Ready";
		Integer relationID = -1;
		RTeamUserDAO relationD=new RTeamUserDAO();
		relationID = relationD.GetRelation(teamID, memberID).getID();
		if (relationID==-1)
		{
			result="Delete Member Failed";
			
		}
		else
		{
			relationD.DeleteRelation(relationID);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String AddMember(Integer memberID,Integer teamID)
	{
		String result="Ready";
		RTeamUserDAO relationD=new RTeamUserDAO();
		try{
			relationD.InsertMember(teamID, memberID);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
	public List<User> GetGroupMember(Integer teamID)
	{
		String result="Ready";
		TeamDAO teamD=new TeamDAO();
		List<User> userList;
		try{
			userList=teamD.getUserByTeam(teamID);
			result="Get Success";
			return userList;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
}
