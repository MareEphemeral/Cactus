package org.cactus.dao;

import java.util.Date;
import java.util.List;

import org.cactus.pojo.Project;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.pojo.UserInfo;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskDAO {

	 
	 public List<Task> getTaskByUser(int userID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        List<Task> taskList = null;
	        List temp;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASK_BY_USER);
	            query.setInteger(0, userID);
	            temp=query.list();
	            for (int i=0;i<temp.size();i++){
	            	taskList.add((Task)((Object[])temp.get(i))[0]) ;
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
	        return taskList;
	    }
	 
	 
	 public List<Task> getTaskBySet(int taskSetID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        List<Task> taskList = null;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASK_BY_TASKSET);
	            query.setInteger(0, taskSetID);
	            taskList=query.list();
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
	        return taskList;
	    }
	 
	 

	
	 public Task getTaskByName(String taskName) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        Task task = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_ALL_TASK_BY_NAME);
	            query.setString(0, taskName.trim());
	            task = (Task)query.uniqueResult();
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
	        return task;
	    }
	 
	 public Task getTaskByID(Integer taskID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        Task task = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASK_BY_ID);
	            query.setInteger(0, taskID);
	            task = (Task)query.uniqueResult();
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
	        return task;
	    }
	 
	 public Task getTaskByName(String projectName,String taskSetName,String taskName) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        Task task = null;
	        List temp;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASK_BY_NAME);
	            query.setString(0, projectName.trim());
	            query.setString(1, taskSetName.trim());
	            query.setString(2, taskName.trim());
	            temp=query.list();
	            task = (Task)((Object[])temp.get(0))[0];
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
	        return task;
	    }
	 
		public void InsertTask(String taskName, Date deadline,Date createTime,Integer process,Integer tasksetID, String taskDesc,Integer creatorID,Integer state)
		{
			Session session = null;
	        Transaction tx = null;
	        Task task = new Task(taskName,deadline,createTime,process,tasksetID,taskDesc,creatorID,state);
	        try {
	        	session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            session.save(task);
	            tx.commit ();
	        }catch(Exception e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	        }finally{  
	            SessionFactory.closeSession();
	        }        
		}
		
		public void UpdateTask(Integer taskID,String taskName, Date careateTime, Date deadline,
				int progress, int taskSetID, String taskDesc, int creatorID,Integer state)
		{
			Session session = null;
	        Transaction tx = null;
	        Task task = new Task(taskName, careateTime,deadline,
	    		 progress, taskSetID, taskDesc,creatorID,state);
	        task.setID(taskID);
	
	        try {
	        	session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            session.update(task);
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
