package org.cactus.dao;

import java.util.Date;
import java.util.List;

import org.cactus.pojo.Project;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectDAO {
	
	public void InsertProject(String projectName, String projectIntro,int creatorID)
	{
		Session session = null;
        Transaction tx = null;
        Project project = new Project(projectName,projectIntro,creatorID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(project);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }
        
	}
	
	 public List<Project> getMyProject(int userID){
	        Session session = null;
	        Transaction tx = null;
	        List<Project> projectList = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_PROJECT_BY_ID);
	            query.setInteger(0, userID);
	            projectList=(List<Project>)query.list();
	           // task = (Task)query.uniqueResult();
	            query = null;
	            tx.commit ();
	        }catch(Exception e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return projectList;
	    }
	 
	 	public List<User> getUserByProject(int projectID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        List<User> userList = null;
	        List temp;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_GROUP_BY_PROJECT_ID);
	            query.setInteger(0, projectID);
	            temp=query.list();
	            for (int i=0;i<temp.size();i++){
	            	userList.add((User)((Object[])temp.get(i))[0]) ;
	            }
	            query = null;
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return userList;
	    }
	 
		public void UpdatepRroject(Integer projectID,String projectName, String projectIntroduction,Integer creatorID)
		{
			Session session = null;
	        Transaction tx = null;
	        Project project = new Project(projectName, projectIntroduction,creatorID);
	        project.setID(projectID);
	
	        try {
	        	session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            session.update(project);
	            tx.commit ();
	        }catch(Exception e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        
		}
		
		
	 
}
