package org.cactus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cactus.pojo.Group;
import org.cactus.pojo.Project;
import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.util.PublicDAO;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProjectDAO {
	
	PublicDAO pDAO;
	public ProjectDAO(){
		pDAO=new PublicDAO();
	}
	
	public void insertProject(Project project)
	{
		pDAO.publicInsert(project);
	}
	
	public void deleteProject(Project project)
	{
		pDAO.publicUpdate(project);
	}
	
	public void updateProject(Project project)
	{
		pDAO.publicUpdate(project);
	}
	
	public Project getProject(Integer projectID) throws HibernateException {
		return (Project)pDAO.publicSearchByID(projectID, SQLCommand.FIND_PROJECT_BY_ID_EM);
	}
	
	public Project getProjectByName(String projectName) throws HibernateException {
		String[] types={"s"};
		Object[] paras={projectName};
		List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_PROJECT_BY_NAME);
		if (!Result.isEmpty()){
			return (Project) Result.get(0);
		}
			else return null;
	}
	
	 public List<Project> getMyProject(int userID) throws HibernateException { 
			String[] types={"i"};
			Object[] paras={userID};
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_PROJECT_BY_ID);
			List<Project> Trueresult= new ArrayList<Project>();
			for (int i=0;i<Result.size();i++)
			{
				Trueresult.add((Project) Result.get(i));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	 }
	 
	 public List<User> getUserByProject(int projectID) throws HibernateException { 
			String[] types={"i"};
			Object[] paras={projectID};
			
			UserDAO userD=new  UserDAO();
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_USER_BY_PROJECT);
			List<User> Trueresult;
			Trueresult = new ArrayList<User>();
			for (int i=0;i<Result.size();i++)
			{
				Object[] temp = (Object[])Result.get(i);				
				Trueresult.add(userD.getUser(((RProjectUser)temp[1]).getUserID()));
			}
			if (!Result.isEmpty()){
				return  Trueresult;
			}
				else return null;
	 }
	 
	 public List<Project> getProjectByUser(int userID) throws HibernateException { 
			String[] types={"i"};
			Object[] paras={userID};
			
			ProjectDAO projectD=new  ProjectDAO();
			List<Object> Result=pDAO.publicAdvancedSearch(types, paras, SQLCommand.FIND_PROJECT_BY_USER);
			List<Project> Trueresult;
			Trueresult = new ArrayList<Project>();
			for (int i=0;i<Result.size();i++)
			{
				Object[] temp = (Object[])Result.get(i);				
				Trueresult.add(projectD.getProject(((RProjectUser)temp[1]).getProjectID()));
			}
			if (!Trueresult.isEmpty()){
				return  Trueresult;
			}
				else return null;
	 }
	 
}
