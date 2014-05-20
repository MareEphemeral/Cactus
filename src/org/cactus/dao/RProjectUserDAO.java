package org.cactus.dao;

import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RProjectUser;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RProjectUserDAO {
	
	public void InsertMember(Integer projectID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RProjectUser relation = new RProjectUser(projectID,userID);
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
	
	public RProjectUser GetRelation(Integer projectID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RProjectUser relation = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(SQLCommand.FIND_RELATION_BY_PROJECT_USER);
            query.setInteger(0, projectID);
            query.setInteger(1, userID);
            relation = (RProjectUser)query.uniqueResult();
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
        RProjectUser relation = new RProjectUser();
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
