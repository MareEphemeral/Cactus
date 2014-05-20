package org.cactus.service;

import java.util.List;

import org.cactus.dao.GroupDAO;
import org.cactus.dao.ProjectDAO;
import org.cactus.dao.RProjectUserDAO;
import org.cactus.dao.RUserTaskDAO;
import org.cactus.dao.UserInfoDAO;
import org.cactus.pojo.Project;
import org.cactus.pojo.User;
import org.cactus.util.ErrorCode;
import org.cactus.util.ErrorCodeList;


public class ProjectManagement {

	public String createProject(String projectName,String projectIntro,int creatorID)
	{
		ErrorCode ec=new ErrorCode();
		
		ProjectDAO proD=new ProjectDAO();
		proD.InsertProject(projectName, projectIntro, creatorID);
		
		return ec.getErrorMessage();
	}
	
	public String UpdateProject(Integer projectID,String projectName, String projectIntroduction,Integer creatorID)
	{
		String result="Ready";
		ProjectDAO projectD=new ProjectDAO();
		
		try{
			projectD.UpdatepRroject(projectID, projectName, projectIntroduction, creatorID);
			result="Update Success";
		}
		catch(Exception ex)
		{
			result="Update Failed";
		}	
		return result;
	}
	
	public String DeleteMember(Integer memberID,Integer projectID)
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
			relationD.DeleteRelation(relationID);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String AddMember(Integer memberID,Integer projectID)
	{
		String result="Ready";
		RProjectUserDAO relationD=new RProjectUserDAO();
		try{
			relationD.InsertMember(projectID, memberID);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
	
	public List<Project> getMyProject(int userID)
	{
		ProjectDAO projectD=new ProjectDAO();
		return projectD.getMyProject(userID);
	}
	
	public List<User> GetProjectMember(Integer projectIDD)
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
	
}
