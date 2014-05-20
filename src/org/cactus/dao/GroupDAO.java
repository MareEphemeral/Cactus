package org.cactus.dao;

import java.util.Date;
import java.util.List;

import org.cactus.pojo.Comment;
import org.cactus.pojo.Group;
import org.cactus.pojo.Task;
import org.cactus.pojo.TaskSet;
import org.cactus.pojo.User;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupDAO {

	public void InsertGroup(String groupName, byte[] authoriyMap, int projectID)
	{
		Session session = null;
        Transaction tx = null;
        Group group = new Group(groupName, authoriyMap, projectID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(group);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	 public List<User> getUserByGroup(int groupID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        List<User> userList = null;
	        List temp;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_USER_BY_GROUP);
	            query.setInteger(0, groupID);
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
	 
	 
	public void UpdateGroup(Integer groupID,String groupName, byte[] authoriyMap, int projectID)
	{
		Session session = null;
        Transaction tx = null;
        Group group = new Group(groupName,authoriyMap,projectID);
        group.setID(groupID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.update(group);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	 public Group getGroup(Integer gorupID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        Group group = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_GROUP_BY_ID);
	            query.setInteger(0, gorupID);
	            group = (Group)query.uniqueResult();
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
	        return group;
	    }
	 
	 public List<Group> getGroupByProject(Integer projectID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        TaskSet taskset = null;
	        List<Group> groupList;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_GROUP_BY_PROJECT_ID);
	            query.setInteger(0, projectID);
	            groupList =query.list();
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return groupList;
	 }
}
