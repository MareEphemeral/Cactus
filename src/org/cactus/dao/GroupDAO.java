package org.cactus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cactus.pojo.Comment;
import org.cactus.pojo.Group;
import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.Task;
import org.cactus.pojo.TaskSet;
import org.cactus.pojo.User;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupDAO {

	PublicDAO pDAO;
	public GroupDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertGroup(Group group)
	{
		pDAO.publicInsert(group);
	}
	
	public void UpdateGroup(Group group)
	{
		pDAO.publicUpdate(group);
	}
	
	public void DeleteGroup(Group group)
	{
		pDAO.publicDelete(group);
	}
	
	public Group GetTargetGroup(Integer projectID,Integer userID)
	{
	 	String[] types={"i","i"};
		Object[] paras={projectID,userID};
	    Object[] Result=(Object[]) pDAO.publicAdvancedSearch(types, paras, SQLCommand.CHECK_AUTHORITY).get(0);
		Group TrueResult=(Group) (Result[1]);
		if (TrueResult!=null){
			return  TrueResult;
		}
			else return null;
	}
	
	 public List<User> getUserByGroup(int groupID) throws HibernateException {
		 	UserDAO userD=new UserDAO();
		 	String[] types={"i"};
			Object[] paras={groupID};
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_USER_BY_GROUP);
			List<User> Trueresult = new ArrayList<User>();
			for (int i=0;i<Result.size();i++)
			{
				Object[] temp = (Object[])Result.get(i);				
				Trueresult.add(userD.getUser(((RGroupUser)temp[1]).getUserID()));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	    }
	 
	
	 public Group getGroup(Integer gorupID) throws HibernateException {
	      return (Group) pDAO.publicSearchByID(gorupID, SQLCommand.FIND_GROUP_BY_ID);
	    }
	 
	 public List<Group> getGroupByProject(Integer projectID) throws HibernateException { 
			String[] types={"i"};
			Object[] paras={projectID};
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_GROUP_BY_PROJECT_ID);
			List<Group> Trueresult=new ArrayList<Group>();
			for (int i=0;i<Result.size();i++)
			{
				Trueresult.add((Group) Result.get(i));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	 }
}
