package org.cactus.service;

import java.util.List;

import org.cactus.dao.GroupDAO;
import org.cactus.dao.ProjectDAO;
import org.cactus.dao.RProjectUserDAO;
import org.cactus.dao.RUserTaskDAO;
import org.cactus.dao.UserInfoDAO;
import org.cactus.pojo.Project;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.User;
import org.cactus.util.ErrorCode;
import org.cactus.util.ErrorCodeList;


public class ProjectManagement {

	public String createProject(String projectName,String projectIntro,int creatorID)
	{
		String result="Create Ready";
		Project targetProject=new Project(projectName,projectIntro,creatorID);
		ProjectDAO proD=new ProjectDAO();
		
		if (proD.getProjectByName(projectName)!=null)
		{
			result="Project Existed";
		}
		else
		{
			proD.insertProject(targetProject);
			result=proD.getProjectByName(projectName).getID().toString();
		}
		return result;
	}
	
	public String updateProject(Integer projectID,String projectName, String projectIntroduction,Integer creatorID)
	{
		String result="Ready";
		Project targetProject=new Project(projectName,projectIntroduction,creatorID);
		targetProject.setID(projectID);
		ProjectDAO projectD=new ProjectDAO();
		
		try{
			projectD.updateProject(targetProject);
			result="Update Success";
		}
		catch(Exception ex)
		{
			result="Update Failed";
		}	
		return result;
	}
	
	
	public List<Project> getMyProject(int userID)
	{
		ProjectDAO projectD=new ProjectDAO();
		return projectD.getMyProject(userID);
	}
	
	public List<User> getProjectMember(Integer projectIDD)
	{
		String result="Ready";
		ProjectDAO projectD=new ProjectDAO();
		List<User> userList;
		try{
			userList=projectD.getUserByProject(projectIDD);
			result="Get Success";
			return userList;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
	public String deleteMember(Integer memberID,Integer projectID)
	{
		String result="Ready";
		Integer relationID = -1;
		RProjectUserDAO relationD=new RProjectUserDAO();
		relationID = relationD.GetRelation(projectID, memberID).getID();
		if (relationID==-1)
		{
			result="Delete Member Failed";
			
		}
		else
		{
			RProjectUser targetMember=new RProjectUser(projectID, memberID);
			targetMember.setID(relationID);
			relationD.deleteMember(targetMember);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String addMember(Integer memberID,Integer projectID)
	{
		String result="Ready";
		RProjectUser targetMember=new RProjectUser(projectID, memberID);
		RProjectUserDAO relationD=new RProjectUserDAO();
		try{
			relationD.insertMember(targetMember);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
}
