package org.cactus.service;

import java.util.Date;
import java.util.List;

import org.cactus.dao.CommentDAO;
import org.cactus.dao.GroupDAO;
import org.cactus.dao.RGroupUserDAO;
import org.cactus.dao.RProjectUserDAO;
import org.cactus.dao.TaskSetDAO;
import org.cactus.pojo.Group;
import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.TaskSet;
import org.cactus.pojo.User;

public class GroupTeamManagement {
	
	public String CreateGroup(String groupName,byte[] authorityMap,Integer projectID){	
		String result="Ready";
		GroupDAO group=new GroupDAO();
		Group targetGroup=new Group(groupName, authorityMap, projectID);
		try{
			group.insertGroup(targetGroup);
			result="Create Success";
		}
		catch(Exception ex)
		{
			result="Create Failed";
		}	
		return result;
	}
	
	public Group GetGroupID(Integer groupID){
		
		String result="Ready";
		GroupDAO groupD=new GroupDAO();
		Group group;
		try{
			group=groupD.getGroup(groupID);
			result="Get Success";
			return group;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
	public String SetAuthority(Integer AuthorityType, Integer groupID, byte newAuthority){	

		String result="ready";
		GroupDAO groupD=new GroupDAO();
		Group tempGroup= GetGroupID(groupID);
		byte[] tempAuthorityMap=tempGroup.getAuthorityMap();
		tempAuthorityMap[AuthorityType]=newAuthority;
		tempGroup.setAuthorityMap(tempAuthorityMap);
		
		try{
			groupD.UpdateGroup(tempGroup);
			result="Get Success";
		}
		catch(Exception ex)
		{
			result="Get Failed";
		
		}	
		return result;
	}
	
	public List<Group> GetGroupByProject(Integer projectID)
	{
		String result="Ready";
		GroupDAO groupD=new GroupDAO();
		List<Group> groupList;
		try{
			groupList=groupD.getGroupByProject(projectID);
			result="Get Success";
			return groupList;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
	public String DeleteMember(Integer memberID,Integer groupID)
	{
		String result="Ready";
		Integer relationID = -1;
		RGroupUserDAO relationD=new RGroupUserDAO();
		relationID = relationD.GetRelation(memberID,groupID).getID();
		if (relationID==-1)
		{
			result="Delete Member Failed";
			
		}
		else
		{
			RGroupUser relation =new RGroupUser();
			relation.setID(relationID);
			relationD.deleteMember(relation);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String AddMember(Integer memberID,Integer groupID)
	{
		String result="Ready";
		RGroupUserDAO relationD=new RGroupUserDAO();
		try{
			RGroupUser relation =new RGroupUser(groupID, memberID);
			relationD.insertMember(relation);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
	public List<User> GetGroupMember(Integer groupID)
	{
		String result="Ready";
		GroupDAO groupD=new GroupDAO();
		List<User> userList;
		try{
			userList=groupD.getUserByGroup(groupID);
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
