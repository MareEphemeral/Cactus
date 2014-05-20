package org.cactus.service;

import java.util.List;

import org.cactus.dao.GroupDAO;
import org.cactus.dao.RGroupUserDAO;
import org.cactus.dao.RTeamUserDAO;
import org.cactus.dao.TeamDAO;
import org.cactus.pojo.Group;
import org.cactus.pojo.RTeamUser;
import org.cactus.pojo.Team;
import org.cactus.pojo.User;

public class TeamManagement {
	
	public String CreateTeam(String teamName, String teamIntro, Integer creatorID){	
		String result="Ready";
		TeamDAO teamD=new TeamDAO();
		Team targerTeam=new Team(teamName, teamIntro, creatorID);
		try{
			teamD.insertTeam(targerTeam);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
	
	public String DeleteTeam(Integer teamID){	
		String result="Ready";
		TeamDAO teamD=new TeamDAO();
		Team targerTeam=new Team();
		targerTeam.setID(teamID);
		try{
			teamD.deleteTeam(targerTeam);
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
		relationID = relationD.GetRelation(memberID,teamID).getID();
		if (relationID==-1)
		{
			result="Delete Member Failed";
			
		}
		else
		{
			RTeamUser relation= new RTeamUser();
			relation.setID(relationID);
			relationD.deleteMember(relation);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String AddMember(Integer memberID,Integer teamID)
	{
		String result="Ready";
		RTeamUserDAO relationD=new RTeamUserDAO();
		try{
			RTeamUser relation=new RTeamUser( teamID, memberID);
			relationD.insertMember(relation);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
	public List<User> GetTeamMember(Integer teamID)
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
