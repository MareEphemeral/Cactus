package org.cactus.dao;

import java.util.Date;

import org.cactus.pojo.RUserTask;
import org.cactus.pojo.Task;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RUserTaskDAO {

	public void InsertMember(Integer taskID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RUserTask relation = new RUserTask(taskID,userID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(relation);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	public RUserTask GetRelation(Integer taskID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RUserTask relation = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(SQLCommand.FIND_RELATION_BY_USER_TASK);
            query.setInteger(0, userID);
            query.setInteger(1, taskID);
            relation = (RUserTask)query.uniqueResult();
            query = null;
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();       
        }     
        return relation;
	}
	
	public void DeleteRelation(Integer relationID)
	{
		Session session = null;
        Transaction tx = null;
        RUserTask relation = new RUserTask();
        relation.setID(relationID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.delete(relation);
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
