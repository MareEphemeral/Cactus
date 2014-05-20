package org.cactus.dao;

import org.cactus.pojo.RGroupUser;
import org.cactus.pojo.RUserTask;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RGroupUserDAO {

	public void InsertMember(Integer groupID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RGroupUser relation = new RGroupUser(groupID,userID);
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
	
	public RGroupUser GetRelation(Integer groupID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RGroupUser relation = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(SQLCommand.FIND_RELATION_BY_GROUP_USER);
            query.setInteger(0, groupID);
            query.setInteger(1, userID);
            relation = (RGroupUser)query.uniqueResult();
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
        RGroupUser relation = new RGroupUser();
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
