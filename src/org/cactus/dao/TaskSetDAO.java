package org.cactus.dao;

import org.cactus.pojo.Project;
import org.cactus.pojo.Task;
import org.cactus.pojo.TaskSet;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class TaskSetDAO {

	 public TaskSet getTaskSet(Integer tasksetID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        TaskSet taskset = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASKSET_BY_ID);
	            query.setInteger(0, tasksetID);
	            taskset = (TaskSet)query.uniqueResult();
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
	        return taskset;
	    }
	 
	 public Integer getTaskSetID(String tasksetName,Integer projectName) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        TaskSet taskset = null;
	        List temp;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.GET_ID_BY_TASKSET_NAME);
	            query.setInteger(1, projectName);
	            query.setString(0, tasksetName.trim());
	            temp =query.list();
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return (Integer) temp.get(0);
	 }
	 
	 public List<TaskSet> getTaskSetByProject(Integer projectID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        TaskSet taskset = null;
	        List<TaskSet> taskSetList;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TASKSET_BY_PROJECT_ID);
	            query.setInteger(0, projectID);
	            taskSetList =query.list();
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return taskSetList;
	 }
	 

		public void InsertTaskSet(String tasksetName, Integer projectID, Integer creatorID)
		{
			Session session = null;
	        Transaction tx = null;
	        TaskSet taskSet = new TaskSet(tasksetName,projectID,creatorID);
	        try {
	        	session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            session.save(taskSet);
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
